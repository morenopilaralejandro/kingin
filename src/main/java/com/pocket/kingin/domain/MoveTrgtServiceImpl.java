package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveTrgtServiceImpl implements MoveTrgtService {
	@Autowired
	private MoveTrgtRepository repo;
	
	@Override
	public List<MoveTrgt> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveTrgt one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveTrgtNotFoundException(id));
	}
	
	@Override
	public MoveTrgt insert(MoveTrgt newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveTrgt replace(MoveTrgt newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveTrgtCode(newObj.getMoveTrgtCode());
			oldObj.setMoveTrgtNameEn(newObj.getMoveTrgtNameEn());
			oldObj.setMoveTrgtNameJa(newObj.getMoveTrgtNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveTrgtId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
