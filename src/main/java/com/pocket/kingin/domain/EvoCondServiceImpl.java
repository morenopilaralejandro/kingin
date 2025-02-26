package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvoCondServiceImpl implements EvoCondService {
	@Autowired
	private EvoCondRepository repo;
	
	@Override
	public List<EvoCond> all() {
		return repo.findAll();
	}
	
	@Override
	public EvoCond one(Long id) {
		return repo.findById(id).orElseThrow(() -> new EvoCondNotFoundException(id));
	}
	
	@Override
	public EvoCond insert(EvoCond newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public EvoCond replace(EvoCond newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setEvoCondCode(newObj.getEvoCondCode());
			oldObj.setEvoCondDescEn(newObj.getEvoCondDescEn());
			oldObj.setEvoCondDescJa(newObj.getEvoCondDescJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEvoCondId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
