package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdServiceImpl implements PdService {
	@Autowired
	private PdRepository repo;
	
	@Override
	public List<Pd> all() {
		return repo.findAll();
	}
	
	@Override
	public List<Pd> findByPdCode(String code) {
		return repo.findByPdCode(code);
	}

	@Override
	public List<Pd> findByPdNameEnContainingIgnoreCase(String pdNameEn) {
		return repo.findByPdNameEnContainingIgnoreCase(pdNameEn);
	}

	@Override
	public List<Pd> findByPdNameJaContainingIgnoreCase(String pdNameJa) {
		return repo.findByPdNameJaContainingIgnoreCase(pdNameJa);
	}
	
	@Override
	public Pd one(Long id) {
		return repo.findById(id).orElseThrow(() -> new PdNotFoundException(id));
	}
	
	@Override
	public Pd insert(Pd newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Pd replace(Pd newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPdCode(newObj.getPdCode());
			oldObj.setPdIndex(newObj.getPdIndex());
			oldObj.setPdNameEn(newObj.getPdNameEn());
			oldObj.setPdNameJa(newObj.getPdNameJa());
			oldObj.setPdImg(newObj.getPdImg());
			oldObj.setPdCapRate(newObj.getPdCapRate());
			oldObj.setPdExp(newObj.getPdExp());
			oldObj.setPdHap(newObj.getPdHap());
			oldObj.setPdBaseHp(newObj.getPdBaseHp());
			oldObj.setPdBaseAtk(newObj.getPdBaseAtk());
			oldObj.setPdBaseDef(newObj.getPdBaseDef());
			oldObj.setPdBaseSpatk(newObj.getPdBaseSpatk());
			oldObj.setPdBaseSpdef(newObj.getPdBaseSpdef());
			oldObj.setPdBaseSpe(newObj.getPdBaseSpe());
			oldObj.setEggCyc(newObj.getEggCyc());
			oldObj.setExpGrp(newObj.getExpGrp());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPdId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
