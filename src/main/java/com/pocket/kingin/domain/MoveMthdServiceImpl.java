package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveMthdServiceImpl implements MoveMthdService {
	@Autowired
	private MoveMthdRepository repo;
	
	@Override
	public List<MoveMthd> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveMthd one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveMthdNotFoundException(id));
	}
	
	@Override
	public MoveMthd insert(MoveMthd newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveMthd replace(MoveMthd newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveMthdCode(newObj.getMoveMthdCode());
			oldObj.setMoveMthdNameEn(newObj.getMoveMthdNameEn());
			oldObj.setMoveMthdNameJa(newObj.getMoveMthdNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveMthdId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
