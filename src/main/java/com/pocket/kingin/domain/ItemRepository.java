package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByItemCode(String code);
	
	List<Item> findByItemPkt(ItemPkt itemPkt);
	
	List<Item> findByItemNameEnContainingIgnoreCase(String itemNameEn);
	
	List<Item> findByItemNameJaContainingIgnoreCase(String itemNameJa);
}
