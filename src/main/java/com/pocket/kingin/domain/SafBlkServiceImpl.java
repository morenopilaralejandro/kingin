package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafBlkServiceImpl implements SafBlkService {
	@Autowired
	private SafBlkRepository repo;
	
	@Override
	public List<SafBlk> all() {
		return repo.findAll();
	}
	
	@Override
	public SafBlk one(Long id) {
		return repo.findById(id).orElseThrow(() -> new SafBlkNotFoundException(id));
	}
	
	@Override
	public SafBlk insert(SafBlk newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public SafBlk replace(SafBlk newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setSafBlkCode(newObj.getSafBlkCode());
			oldObj.setSafBlkNameEn(newObj.getSafBlkNameEn());
			oldObj.setSafBlkNameJa(newObj.getSafBlkNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setSafBlkId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
