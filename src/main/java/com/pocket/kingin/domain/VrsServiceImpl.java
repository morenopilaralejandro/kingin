package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VrsServiceImpl implements VrsService {
	@Autowired
	private VrsRepository repo;
	
	@Override
	public List<Vrs> all() {
		return repo.findAll();
	}
	
	@Override
	public Vrs one(Long id) {
		return repo.findById(id).orElseThrow(() -> new VrsNotFoundException(id));
	}
	
	@Override
	public Vrs insert(Vrs newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Vrs replace(Vrs newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setVrsCode(newObj.getVrsCode());
			oldObj.setVrsNameEn(newObj.getVrsNameEn());
			oldObj.setVrsNameJa(newObj.getVrsNameJa());
			oldObj.setVrsSym(newObj.getVrsSym());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setVrsId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
