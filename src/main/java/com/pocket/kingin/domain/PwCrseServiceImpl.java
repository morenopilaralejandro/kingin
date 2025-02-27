package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PwCrseServiceImpl implements PwCrseService {
	@Autowired
	private PwCrseRepository repo;
	
	@Override
	public List<PwCrse> all() {
		return repo.findAll();
	}
	
	@Override
	public PwCrse one(Long id) {
		return repo.findById(id).orElseThrow(() -> new PwCrseNotFoundException(id));
	}
	
	@Override
	public PwCrse insert(PwCrse newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public PwCrse replace(PwCrse newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPwCrseCode(newObj.getPwCrseCode());
			oldObj.setPwCrseNameEn(newObj.getPwCrseNameEn());
			oldObj.setPwCrseNameJa(newObj.getPwCrseNameJa());
			oldObj.setPwUnlc(newObj.getPwUnlc());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPwCrseId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
