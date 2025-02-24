package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveEffServiceImpl implements MoveEffService {
	@Autowired
	private MoveEffRepository repo;
	
	@Override
	public List<MoveEff> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveEff one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveEffNotFoundException(id));
	}
	
	@Override
	public MoveEff insert(MoveEff newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveEff replace(MoveEff newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveEffCode(newObj.getMoveEffCode());
			oldObj.setMoveEffDescEn(newObj.getMoveEffDescEn());
			oldObj.setMoveEffDescJa(newObj.getMoveEffDescJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveEffId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
