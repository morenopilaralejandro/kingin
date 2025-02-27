package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemObtServiceImpl implements ItemObtService {
	@Autowired
	private ItemObtRepository repo;
	
	@Override
	public List<ItemObt> all() {
		return repo.findAll();
	}
	
	@Override
	public ItemObt one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemObtNotFoundException(id));
	}
	
	@Override
	public ItemObt insert(ItemObt newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public ItemObt replace(ItemObt newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemObtCode(newObj.getItemObtCode());
			oldObj.setItemObtNameEn(newObj.getItemObtNameEn());
			oldObj.setItemObtNameJa(newObj.getItemObtNameJa());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setItemObtId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
