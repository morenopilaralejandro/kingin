package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository repo;
	
	@Override
	public List<Item> all() {
		return repo.findAll();
	}
	
	@Override
	public List<Item> findByItemCode(String code) {
		return repo.findByItemCode(code);
	}
	
	@Override
	public List<Item> findByItemPkt(ItemPkt itemPkt) {
		return repo.findByItemPkt(itemPkt);
	}

	@Override
	public List<Item> findByItemNameEnContainingIgnoreCase(String itemNameEn) {
		return repo.findByItemNameEnContainingIgnoreCase(itemNameEn);
	}

	@Override
	public List<Item> findByItemNameJaContainingIgnoreCase(String itemNameJa) {
		return repo.findByItemNameJaContainingIgnoreCase(itemNameJa);
	}
	
	@Override
	public Item one(Long id) {
		return repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}
	
	@Override
	public Item insert(Item newObj) {
		return repo.save(newObj);
	}
	
	@Override
	public Item replace(Item newObj, Long id) {
		return repo.findById(id).map(oldObj -> {
			oldObj.setItemCode(newObj.getItemCode());
			oldObj.setItemNameEn(newObj.getItemNameEn());
			oldObj.setItemNameJa(newObj.getItemNameJa());
			oldObj.setItemDescEn(newObj.getItemDescEn());
			oldObj.setItemDescJa(newObj.getItemDescJa());
			oldObj.setItemPriceBuyYe(newObj.getItemPriceBuyYe());
			oldObj.setItemPriceSelYe(newObj.getItemPriceSelYe());
			oldObj.setItemPriceBuyBp(newObj.getItemPriceBuyBp());
			oldObj.setItemPriceBuyCn(newObj.getItemPriceBuyCn());
			oldObj.setItemPriceBuyAp(newObj.getItemPriceBuyAp());
			oldObj.setItemFlin(newObj.getItemFlin());
			oldObj.setItemType(newObj.getItemType());
			oldObj.setItemPkt(newObj.getItemPkt());
			oldObj.setItemCat(newObj.getItemCat());
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
