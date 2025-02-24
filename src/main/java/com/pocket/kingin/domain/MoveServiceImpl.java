package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService {
	@Autowired
	private MoveRepository repo;
	
	@Override
	public List<Move> all() {
		return repo.findAll();
	}
	
	@Override
	public Move one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveNotFoundException(id));
	}
	
	@Override
	public Move insert(Move newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Move replace(Move newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveCode(newObj.getMoveCode());
			oldObj.setMoveNameEn(newObj.getMoveNameEn());
			oldObj.setMoveNameJa(newObj.getMoveNameJa());
			oldObj.setMovePp(newObj.getMovePp());
			oldObj.setMoveBp(newObj.getMoveBp());
			oldObj.setMoveAc(newObj.getMoveAc());
			oldObj.setMovePrio(newObj.getMovePrio());
			oldObj.setMoveIsBright(newObj.getMoveIsBright());
			oldObj.setMoveIsking(newObj.getMoveIsking());
			oldObj.setMoveIscontact(newObj.getMoveIscontact());
			oldObj.setType(newObj.getType());
			oldObj.setMoveCat(newObj.getMoveCat());
			oldObj.setMoveTrgt(newObj.getMoveTrgt());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
