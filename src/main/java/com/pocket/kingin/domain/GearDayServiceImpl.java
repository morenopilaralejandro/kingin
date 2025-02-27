package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GearDayServiceImpl implements GearDayService {
	@Autowired
	private GearDayRepository repo;
	
	@Override
	public List<GearDay> all() {
		return repo.findAll();
	}
	
	@Override
	public GearDay one(Long id) {
		return repo.findById(id).orElseThrow(() -> new GearDayNotFoundException(id));
	}
	
	@Override
	public GearDay insert(GearDay newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public GearDay replace(GearDay newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setGearDayCode(newObj.getGearDayCode());
			oldObj.setGearDayNameEn(newObj.getGearDayNameEn());
			oldObj.setGearDayNameJa(newObj.getGearDayNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGearDayId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
