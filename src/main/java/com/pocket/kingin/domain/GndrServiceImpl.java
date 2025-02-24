package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GndrServiceImpl implements GndrService {
	@Autowired
	private GndrRepository repo;
	
	@Override
	public List<Gndr> all() {
		return repo.findAll();
	}
	
	@Override
	public Gndr one(Long id) {
		return repo.findById(id).orElseThrow(() -> new GndrNotFoundException(id));
	}
	
	@Override
	public Gndr insert(Gndr newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Gndr replace(Gndr newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setGndrCode(newObj.getGndrCode());
			oldObj.setGndrNameEn(newObj.getGndrNameEn());
			oldObj.setGndrNameJa(newObj.getGndrNameJa());
			oldObj.setGndrSym(newObj.getGndrSym());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setGndrId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
