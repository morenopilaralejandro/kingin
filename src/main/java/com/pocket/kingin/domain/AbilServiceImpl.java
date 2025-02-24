package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilServiceImpl implements AbilService {
	@Autowired
	private AbilRepository repo;
	
	@Override
	public List<Abil> all() {
		return repo.findAll();
	}
	
	@Override
	public Abil one(Long id) {
		return repo.findById(id).orElseThrow(() -> new AbilNotFoundException(id));
	}
	
	@Override
	public Abil insert(Abil newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Abil replace(Abil newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setAbilCode(newObj.getAbilCode());
			oldObj.setAbilNameEn(newObj.getAbilNameEn());
			oldObj.setAbilNameJa(newObj.getAbilNameJa());
			oldObj.setRole(newObj.isRole());
			oldObj.setRece(newObj.isRece());
			oldObj.setEntr(newObj.isEntr());
			oldObj.setTrac(newObj.isTrac());
			oldObj.setSksw(newObj.isSksw());
			oldObj.setGast(newObj.isGast());
			oldObj.setMold(newObj.isMold());
			oldObj.setTran(newObj.isTran());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setAbilId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
