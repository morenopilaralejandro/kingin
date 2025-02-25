package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private ItemCatRepository repo;
	
	@Override
	public List<ItemCat> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemCat one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemCatNotFoundException(id));
	}
	
	@Override
	public ItemCat insert(ItemCat newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemCat replace(ItemCat newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemCatCode(newObj.getItemCatCode());
			oldObj.setItemCatNameEn(newObj.getItemCatNameEn());
			oldObj.setItemCatNameJa(newObj.getItemCatNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemCatId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
