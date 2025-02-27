package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GearTimeServiceImpl implements GearTimeService {
	@Autowired
	private GearTimeRepository repo;
	
	@Override
	public List<GearTime> all() {
		return repo.findAll();
	}
	
	@Override
	public GearTime one(Long id) {
		return repo.findById(id).orElseThrow(() -> new GearTimeNotFoundException(id));
	}
	
	@Override
	public GearTime insert(GearTime newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public GearTime replace(GearTime newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setGearTimeCode(newObj.getGearTimeCode());
			oldObj.setGearTimeNameEn(newObj.getGearTimeNameEn());
			oldObj.setGearTimeNameJa(newObj.getGearTimeNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGearTimeId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
