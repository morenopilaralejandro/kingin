package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMachServiceImpl implements ItemMachService {
	@Autowired
	private ItemMachRepository repo;
	
	@Override
	public List<ItemMach> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemMach one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemMachNotFoundException(id));
	}
	
	@Override
	public ItemMach insert(ItemMach newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemMach replace(ItemMach newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemMachNum(newObj.getItemMachNum());
			oldObj.setItemMachObt(newObj.getItemMachObt());
			oldObj.setMove(newObj.getMove());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemMachId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
