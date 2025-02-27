package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtiServiceImpl implements ArtiService {
	@Autowired
	private ArtiRepository repo;
	
	@Override
	public List<Arti> all() {
		return repo.findAll();
	}
	
	@Override
	public Arti one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ArtiNotFoundException(id));
	}
	
	@Override
	public Arti insert(Arti newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Arti replace(Arti newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setArtiCode(newObj.getArtiCode());
			oldObj.setArtiNameEn(newObj.getArtiNameEn());
			oldObj.setArtiNameJa(newObj.getArtiNameJa());
			oldObj.setArtiView(newObj.getArtiView());
			oldObj.setArtiType(newObj.getArtiType());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setArtiId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
