package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrServiceImpl implements CurrService {
	@Autowired
	private CurrRepository repo;
	
	@Override
	public List<Curr> all() {
		return repo.findAll();
	}
	
	@Override
	public Curr one(Long id) {
		return repo.findById(id).orElseThrow(() -> new CurrNotFoundException(id));
	}
	
	@Override
	public Curr insert(Curr newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Curr replace(Curr newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setCurrCode(newObj.getCurrCode());
			oldObj.setCurrNameEn(newObj.getCurrNameEn());
			oldObj.setCurrNameJa(newObj.getCurrNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setCurrId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
