package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpGrpServiceImpl implements ExpGrpService {
	@Autowired
	private ExpGrpRepository repo;
	
	@Override
	public List<ExpGrp> all() {
		return repo.findAll();
	}
	
	@Override
	public ExpGrp one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ExpGrpNotFoundException(id));
	}
	
	@Override
	public ExpGrp insert(ExpGrp newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ExpGrp replace(ExpGrp newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setExpGrpCode(newObj.getExpGrpCode());
			oldObj.setExpGrpNameEn(newObj.getExpGrpNameEn());
			oldObj.setExpGrpNameJa(newObj.getExpGrpNameJa());
			oldObj.setExpGrpFinal(newObj.getExpGrpFinal());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setExpGrpId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
