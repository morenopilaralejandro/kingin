package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggCycServiceImpl implements EggCycService {
	@Autowired
	private EggCycRepository repo;
	
	@Override
	public List<EggCyc> all() {
		return repo.findAll();
	}
	
	@Override
	public EggCyc one(Long id) {
		return repo.findById(id).orElseThrow(() -> new EggCycNotFoundException(id));
	}
	
	@Override
	public EggCyc insert(EggCyc newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public EggCyc replace(EggCyc newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setEggCycCode(newObj.getEggCycCode());
			oldObj.setEggCycVal(newObj.getEggCycVal());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEggCycId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
