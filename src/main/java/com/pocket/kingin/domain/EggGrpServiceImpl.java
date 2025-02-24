package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggGrpServiceImpl implements EggGrpService {
	@Autowired
	private EggGrpRepository repo;
	
	@Override
	public List<EggGrp> all() {
		return repo.findAll();
	}
	
	@Override
	public EggGrp one(Long id) {
		return repo.findById(id).orElseThrow(() -> new EggGrpNotFoundException(id));
	}
	
	@Override
	public EggGrp insert(EggGrp newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public EggGrp replace(EggGrp newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setEggGrpCode(newObj.getEggGrpCode());
			oldObj.setEggGrpNameEn(newObj.getEggGrpNameEn());
			oldObj.setEggGrpNameJa(newObj.getEggGrpNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setEggGrpId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
