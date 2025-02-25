package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
	@Autowired
	private ItemTypeRepository repo;
	
	@Override
	public List<ItemType> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemType one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemTypeNotFoundException(id));
	}
	
	@Override
	public ItemType insert(ItemType newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemType replace(ItemType newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemTypeCode(newObj.getItemTypeCode());
			oldObj.setItemTypeNameEn(newObj.getItemTypeNameEn());
			oldObj.setItemTypeNameJa(newObj.getItemTypeNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemTypeId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
