package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GearCallServiceImpl implements GearCallService {
	@Autowired
	private GearCallRepository repo;
	
	@Override
	public List<GearCall> all() {
		return repo.findAll();
	}
	
	@Override
	public GearCall one(Long id) {
		return repo.findById(id).orElseThrow(() -> new GearCallNotFoundException(id));
	}
	
	@Override
	public GearCall insert(GearCall newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public GearCall replace(GearCall newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setGearCallCode(newObj.getGearCallCode());
			oldObj.setGearDay(newObj.getGearDay());
			oldObj.setGearTime(newObj.getGearTime());
			oldObj.setNpc(newObj.getNpc());
			oldObj.setZone(newObj.getZone());
			oldObj.setMoney(newObj.getMoney());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGearCallId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
