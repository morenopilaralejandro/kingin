package com.pocket.kingin.domain;

import java.util.List;

public interface ItemService {
	List<Item> all();
	
	List<Item> findByItemCode(String code);
	
	List<Item> findByItemPkt(ItemPkt itemPkt);
	
	List<Item> findByItemNameEnContainingIgnoreCase(String itemNameEn);
	
	List<Item> findByItemNameJaContainingIgnoreCase(String itemNameJa);

	Item one(Long id);

	Item insert(Item newObj);

	Item replace(Item newObj, Long id);

	void delete(Long id);
}
