package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilEffServiceImpl implements AbilEffService {
	@Autowired
	private AbilEffRepository repo;
	
	@Override
	public List<AbilEff> all() {
		return repo.findAll();
	}
	
	@Override
	public AbilEff one(Long id) {
		return repo.findById(id).orElseThrow(() -> new AbilEffNotFoundException(id));
	}
	
	@Override
	public AbilEff insert(AbilEff newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public AbilEff replace(AbilEff newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setAbilEffCode(newObj.getAbilEffCode());
			oldObj.setAbilEffDescEn(newObj.getAbilEffDescEn());
			oldObj.setAbilEffDescJa(newObj.getAbilEffDescJa());
			oldObj.setAbilEffType(newObj.getAbilEffType());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setAbilEffId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
