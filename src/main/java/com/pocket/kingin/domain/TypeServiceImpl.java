package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeRepository repo;
	
	@Override
	public List<Type> all() {
		return repo.findAll();
	}
	
	@Override
	public Type one(Long id) {
		return repo.findById(id).orElseThrow(() -> new TypeNotFoundException(id));
	}
	
	@Override
	public Type insert(Type newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Type replace(Type newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setTypeCode(newObj.getTypeCode());
			oldObj.setTypeNameEn(newObj.getTypeNameEn());
			oldObj.setTypeNameJa(newObj.getTypeNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setTypeId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
