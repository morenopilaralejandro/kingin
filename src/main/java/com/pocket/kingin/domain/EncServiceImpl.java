package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncServiceImpl implements EncService {
	@Autowired
	private EncRepository repo;
	
	@Override
	public List<Enc> all() {
		return repo.findAll();
	}
	
	@Override
	public Enc one(Long id) {
		return repo.findById(id).orElseThrow(() -> new EncNotFoundException(id));
	}
	
	@Override
	public Enc insert(Enc newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Enc replace(Enc newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setEncCode(newObj.getEncCode());
			oldObj.setEncNameEn(newObj.getEncNameEn());
			oldObj.setEncNameJa(newObj.getEncNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEncId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
