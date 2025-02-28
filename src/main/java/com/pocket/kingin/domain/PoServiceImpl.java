package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoServiceImpl implements PoService {
	@Autowired
	private PoRepository repo;
	
	@Override
	public List<Po> all() {
		return repo.findAll();
	}
	
	@Override
	public Po one(Long id) {
		return repo.findById(id).orElseThrow(() -> new PoNotFoundException(id));
	}
	
	@Override
	public Po insert(Po newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Po replace(Po newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPoUuid(newObj.getPoUuid());
			oldObj.setPoDateCrt(newObj.getPoDateCrt());
			oldObj.setPoDateMod(newObj.getPoDateMod());
			oldObj.setPoDefHp(newObj.getPoDefHp());
			oldObj.setPoDefAtk(newObj.getPoDefAtk());
			oldObj.setPoDefDef(newObj.getPoDefDef());
			oldObj.setPoDefSpatk(newObj.getPoDefSpatk());
			oldObj.setPoDefSpdef(newObj.getPoDefSpdef());
			oldObj.setPoDefSpe(newObj.getPoDefSpe());
			oldObj.setPoCurHp(newObj.getPoCurHp());
			oldObj.setPoCurAtk(newObj.getPoCurAtk());
			oldObj.setPoCurDef(newObj.getPoCurDef());
			oldObj.setPoCurSpatk(newObj.getPoCurSpatk());
			oldObj.setPoCurSpdef(newObj.getPoCurSpdef());
			oldObj.setPoCurSpe(newObj.getPoCurSpe());
			oldObj.setPoEvHp(newObj.getPoEvHp());
			oldObj.setPoEvAtk(newObj.getPoEvAtk());
			oldObj.setPoEvDef(newObj.getPoEvDef());
			oldObj.setPoEvSpatk(newObj.getPoEvSpatk());
			oldObj.setPoEvSpdef(newObj.getPoEvSpdef());
			oldObj.setPoEvSpe(newObj.getPoEvSpe());
			oldObj.setPoIsSaikoHp(newObj.getPoIsSaikoHp());
			oldObj.setPoIsSaikoAtk(newObj.getPoIsSaikoAtk());
			oldObj.setPoIsSaikoDef(newObj.getPoIsSaikoDef());
			oldObj.setPoIsSaikoSpatk(newObj.getPoIsSaikoSpatk());
			oldObj.setPoIsSaikoSpdef(newObj.getPoIsSaikoSpdef());
			oldObj.setPoIsSaikoSpe(newObj.getPoIsSaikoSpe());
			oldObj.setPoIsPriv(newObj.getPoIsPriv());
			oldObj.setPd(newObj.getPd());
			oldObj.setUsr(newObj.getUsr());
			oldObj.setAbil(newObj.getAbil());
			oldObj.setNatu(newObj.getNatu());
			oldObj.setGndr(newObj.getGndr());	
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setPoId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
