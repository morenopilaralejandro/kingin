package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtiTypeServiceImpl implements ArtiTypeService {
	@Autowired
	private ArtiTypeRepository repo;
	
	@Override
	public List<ArtiType> all() {
		return repo.findAll();
	}
	
	@Override
	public ArtiType one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ArtiTypeNotFoundException(id));
	}
	
	@Override
	public ArtiType insert(ArtiType newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ArtiType replace(ArtiType newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setArtiTypeCode(newObj.getArtiTypeCode());
			oldObj.setArtiTypeNameEn(newObj.getArtiTypeNameEn());
			oldObj.setArtiTypeNameJa(newObj.getArtiTypeNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setArtiTypeId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
