package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPktServiceImpl implements ItemPktService {
	@Autowired
	private ItemPktRepository repo;
	
	@Override
	public List<ItemPkt> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemPkt one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemPktNotFoundException(id));
	}
	
	@Override
	public ItemPkt insert(ItemPkt newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemPkt replace(ItemPkt newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemPktCode(newObj.getItemPktCode());
			oldObj.setItemPktNameEn(newObj.getItemPktNameEn());
			oldObj.setItemPktNameJa(newObj.getItemPktNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemPktId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
