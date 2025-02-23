package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService {
	@Autowired
	private StatRepository statRepository;
	
	@Override
	public List<Stat> all() {
		return statRepository.findAll();
	}
	
	@Override
	public Stat one(Long id) {
		return statRepository.findById(id).orElseThrow(() -> new StatNotFoundException(id));
	}
	
	@Override
	public Stat insert(Stat newObj) {
		return statRepository.save(newObj);
	}
	
	@Override
	public Stat replace(Stat newObj, Long id) {
		return statRepository.findById(id).map(oldObj -> {
			oldObj.setStatCode(newObj.getStatCode());
			oldObj.setStatNameEn(newObj.getStatNameEn());
			oldObj.setStatNameJa(newObj.getStatNameJa());
			return statRepository.save(oldObj);
		}).orElseGet(() -> {
			newObj.setStatId(id);
			return statRepository.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		statRepository.deleteById(id);
	}
	
}
