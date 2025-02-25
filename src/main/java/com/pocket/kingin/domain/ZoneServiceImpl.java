package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneServiceImpl implements ZoneService {
	@Autowired
	private ZoneRepository repo;
	
	@Override
	public List<Zone> all() {
		return repo.findAll();
	}
	
	@Override
	public Zone one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ZoneNotFoundException(id));
	}
	
	@Override
	public Zone insert(Zone newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Zone replace(Zone newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setZoneCode(newObj.getZoneCode());
			oldObj.setZoneName(newObj.getZoneName());
			oldObj.setZoneMain(newObj.getZoneMain());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setZoneId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
