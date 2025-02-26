package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemFossServiceImpl implements ItemFossService {
	@Autowired
	private ItemFossRepository repo;
	
	@Override
	public List<ItemFoss> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemFoss one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemFossNotFoundException(id));
	}
	
	@Override
	public ItemFoss insert(ItemFoss newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemFoss replace(ItemFoss newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setPd(newObj.getPd());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
