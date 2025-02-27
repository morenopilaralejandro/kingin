package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcTitleServiceImpl implements NpcTitleService {
	@Autowired
	private NpcTitleRepository repo;
	
	@Override
	public List<NpcTitle> all() {
		return repo.findAll();
	}
	
	@Override
	public NpcTitle one(Long id) {
		return repo.findById(id).orElseThrow(() -> new NpcTitleNotFoundException(id));
	}
	
	@Override
	public NpcTitle insert(NpcTitle newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public NpcTitle replace(NpcTitle newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setNpcTitleCode(newObj.getNpcTitleCode());
			oldObj.setNpcTitleNameEn(newObj.getNpcTitleNameEn());
			oldObj.setNpcTitleNameJa(newObj.getNpcTitleNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setNpcTitleId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
