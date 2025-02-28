package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FcServiceImpl implements FcService {
	@Autowired
	private FcRepository repo;
	
	@Override
	public List<Fc> all() {
		return repo.findAll();
	}
	
	@Override
	public Fc one(Long id) {
		return repo.findById(id).orElseThrow(() -> new FcNotFoundException(id));
	}
	
	@Override
	public Fc insert(Fc newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Fc replace(Fc newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setFcCode(newObj.getFcCode());
			oldObj.setFcName(newObj.getFcName());
			oldObj.setUsr(newObj.getUsr());
			oldObj.setVrs(newObj.getVrs());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setFcId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
