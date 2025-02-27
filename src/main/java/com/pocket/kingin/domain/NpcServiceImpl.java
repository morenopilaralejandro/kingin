package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcServiceImpl implements NpcService {
	@Autowired
	private NpcRepository repo;
	
	@Override
	public List<Npc> all() {
		return repo.findAll();
	}
	
	@Override
	public Npc one(Long id) {
		return repo.findById(id).orElseThrow(() -> new NpcNotFoundException(id));
	}
	
	@Override
	public Npc insert(Npc newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Npc replace(Npc newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setNpcCode(newObj.getNpcCode());
			oldObj.setNpcNameEn(newObj.getNpcNameEn());
			oldObj.setNpcNameJa(newObj.getNpcNameJa());
			oldObj.setNpcTitle(newObj.getNpcTitle());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setNpcId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
