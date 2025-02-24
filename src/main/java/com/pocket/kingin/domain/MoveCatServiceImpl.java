package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveCatServiceImpl implements MoveCatService {
	@Autowired
	private MoveCatRepository repo;
	
	@Override
	public List<MoveCat> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveCat one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveCatNotFoundException(id));
	}
	
	@Override
	public MoveCat insert(MoveCat newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveCat replace(MoveCat newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveCatCode(newObj.getMoveCatCode());
			oldObj.setMoveCatNameEn(newObj.getMoveCatNameEn());
			oldObj.setMoveCatNameJa(newObj.getMoveCatNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveCatId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
