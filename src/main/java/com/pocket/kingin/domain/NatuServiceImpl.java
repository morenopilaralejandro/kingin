package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NatuServiceImpl implements NatuService {
	@Autowired
	private NatuRepository repo;
	
	@Override
	public List<Natu> all() {
		return repo.findAll();
	}
	
	@Override
	public Natu one(Long id) {
		return repo.findById(id).orElseThrow(() -> new NatuNotFoundException(id));
	}
	
	@Override
	public Natu insert(Natu newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Natu replace(Natu newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setNatuCode(newObj.getNatuCode());
			oldObj.setNatuNameEn(newObj.getNatuNameEn());
			oldObj.setNatuNameJa(newObj.getNatuNameJa());
			oldObj.setStatRed(newObj.getStatRed());
			oldObj.setStatBlue(newObj.getStatBlue());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setNatuId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
