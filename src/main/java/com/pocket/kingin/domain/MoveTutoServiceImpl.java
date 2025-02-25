package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveTutoServiceImpl implements MoveTutoService {
	@Autowired
	private MoveTutoRepository repo;
	
	@Override
	public List<MoveTuto> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveTuto one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveTutoNotFoundException(id));
	}
	
	@Override
	public MoveTuto insert(MoveTuto newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveTuto replace(MoveTuto newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveTutoCode(newObj.getMoveTutoCode());
			oldObj.setMoveTutoNameEn(newObj.getMoveTutoNameEn());
			oldObj.setMoveTutoNameJa(newObj.getMoveTutoNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveTutoId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
