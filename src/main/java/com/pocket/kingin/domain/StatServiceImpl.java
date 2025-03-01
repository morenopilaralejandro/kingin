package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService {
	@Autowired
	private StatRepository repo;
	
	@Override
	public List<Stat> all() {
		return repo.findAll();
	}
	
	@Override
	public Stat one(Long id) {
		return repo.findById(id).orElseThrow(() -> new StatNotFoundException(id));
	}
	
	@Override
	public Stat insert(Stat newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Stat replace(Stat newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setStatCode(newObj.getStatCode());
			oldObj.setStatNameEn(newObj.getStatNameEn());
			oldObj.setStatNameJa(newObj.getStatNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setStatId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
