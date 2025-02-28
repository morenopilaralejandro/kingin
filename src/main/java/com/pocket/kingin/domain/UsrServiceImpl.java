package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrServiceImpl implements UsrService {
	@Autowired
	private UsrRepository repo;
	
	@Override
	public List<Usr> all() {
		return repo.findAll();
	}
	
	@Override
	public Usr one(Long id) {
		return repo.findById(id).orElseThrow(() -> new UsrNotFoundException(id));
	}
	
	@Override
	public Usr insert(Usr newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Usr replace(Usr newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setUsrUuid(newObj.getUsrUuid());
			oldObj.setUsrName(newObj.getUsrName());
			oldObj.setUsrPass(newObj.getUsrPass());
			oldObj.setUsrMail(newObj.getUsrMail());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setUsrId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
