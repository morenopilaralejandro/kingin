package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilEffTypeServiceImpl implements AbilEffTypeService {
	@Autowired
	private AbilEffTypeRepository repo;
	
	@Override
	public List<AbilEffType> all() {
		return repo.findAll();
	}
	
	@Override
	public AbilEffType one(Long id) {
		return repo.findById(id).orElseThrow(() -> new AbilEffTypeNotFoundException(id));
	}
	
	@Override
	public AbilEffType insert(AbilEffType newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public AbilEffType replace(AbilEffType newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setAbilEffTypeCode(newObj.getAbilEffTypeCode());
			oldObj.setAbilEffTypeNameEn(newObj.getAbilEffTypeNameEn());
			oldObj.setAbilEffTypeNameJa(newObj.getAbilEffTypeNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setAbilEffTypeId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
