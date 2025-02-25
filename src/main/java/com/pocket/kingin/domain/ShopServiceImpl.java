package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopRepository repo;
	
	@Override
	public List<Shop> all() {
		return repo.findAll();
	}
	
	@Override
	public Shop one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
	}
	
	@Override
	public Shop insert(Shop newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Shop replace(Shop newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setShopCode(newObj.getShopCode());
			oldObj.setShopNameEn(newObj.getShopNameEn());
			oldObj.setShopNameJa(newObj.getShopNameJa());
			oldObj.setZone(newObj.getZone());
			oldObj.setCurr(newObj.getCurr());
			return repo.save(oldObj);
		}).orElseGet(() -> {
			newObj.setShopId(id);
			return repo.save(newObj);
		});
	}
	
	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
