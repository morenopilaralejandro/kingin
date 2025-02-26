package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvoFamServiceImpl implements EvoFamService {
	@Autowired
	private EvoFamRepository repo;
	
	@Override
	public List<EvoFam> all() {
		return repo.findAll();
	}
	
	@Override
	public EvoFam one(Long id) {
		return repo.findById(id).orElseThrow(() -> new EvoFamNotFoundException(id));
	}
	
	@Override
	public EvoFam insert(EvoFam newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public EvoFam replace(EvoFam newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setEvoFamCode(newObj.getEvoFamCode());
			oldObj.setEvoFamNameEn(newObj.getEvoFamNameEn());
			oldObj.setEvoFamNameJa(newObj.getEvoFamNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEvoFamId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
