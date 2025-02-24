package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveLrnServiceImpl implements MoveLrnService {
	@Autowired
	private MoveLrnRepository repo;
	
	@Override
	public List<MoveLrn> all() {
		return repo.findAll();
	}
	
	@Override
	public MoveLrn one(Long id) {
		return repo.findById(id).orElseThrow(() -> new MoveLrnNotFoundException(id));
	}
	
	@Override
	public MoveLrn insert(MoveLrn newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public MoveLrn replace(MoveLrn newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setMoveLrnCode(newObj.getMoveLrnCode());
			oldObj.setMoveLrnNameEn(newObj.getMoveLrnNameEn());
			oldObj.setMoveLrnNameJa(newObj.getMoveLrnNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setMoveLrnId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
