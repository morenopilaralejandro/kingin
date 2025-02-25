package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneNameServiceImpl implements ZoneNameService {
	@Autowired
	private ZoneNameRepository repo;
	
	@Override
	public List<ZoneName> all() {
		return repo.findAll();
	}
	
	@Override
	public ZoneName one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ZoneNameNotFoundException(id));
	}
	
	@Override
	public ZoneName insert(ZoneName newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ZoneName replace(ZoneName newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setZoneNameCode(newObj.getZoneNameCode());
			oldObj.setZoneNameEn(newObj.getZoneNameEn());
			oldObj.setZoneNameJa(newObj.getZoneNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneNameId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
