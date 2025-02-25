package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMachObtServiceImpl implements ItemMachObtService {
	@Autowired
	private ItemMachObtRepository repo;
	
	@Override
	public List<ItemMachObt> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemMachObt one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemMachObtNotFoundException(id));
	}
	
	@Override
	public ItemMachObt insert(ItemMachObt newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemMachObt replace(ItemMachObt newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemMachObtCode(newObj.getItemMachObtCode());
			oldObj.setItemMachObtNameEn(newObj.getItemMachObtNameEn());
			oldObj.setItemMachObtNameJa(newObj.getItemMachObtNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemMachObtId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
