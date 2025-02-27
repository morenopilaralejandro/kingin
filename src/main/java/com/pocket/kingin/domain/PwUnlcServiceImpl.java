package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PwUnlcServiceImpl implements PwUnlcService {
	@Autowired
	private PwUnlcRepository repo;
	
	@Override
	public List<PwUnlc> all() {
		return repo.findAll();
	}
	
	@Override
	public PwUnlc one(Long id) {
		return repo.findById(id).orElseThrow(() -> new PwUnlcNotFoundException(id));
	}
	
	@Override
	public PwUnlc insert(PwUnlc newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public PwUnlc replace(PwUnlc newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPwUnlcCode(newObj.getPwUnlcCode());
			oldObj.setPwUnlcNameEn(newObj.getPwUnlcNameEn());
			oldObj.setPwUnlcNameJa(newObj.getPwUnlcNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPwUnlcId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
