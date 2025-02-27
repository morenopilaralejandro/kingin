package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PwGrpServiceImpl implements PwGrpService {
	@Autowired
	private PwGrpRepository repo;
	
	@Override
	public List<PwGrp> all() {
		return repo.findAll();
	}
	
	@Override
	public PwGrp one(Long id) {
		return repo.findById(id).orElseThrow(() -> new PwGrpNotFoundException(id));
	}
	
	@Override
	public PwGrp insert(PwGrp newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public PwGrp replace(PwGrp newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPwGrpCode(newObj.getPwGrpCode());
			oldObj.setPwGrpNameEn(newObj.getPwGrpNameEn());
			oldObj.setPwGrpNameJa(newObj.getPwGrpNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPwGrpId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
