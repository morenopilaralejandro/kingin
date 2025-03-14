package com.pocket.kingin.domain;

import java.util.List;

public interface ItemPktService {
	List<ItemPkt> all();
	
	List<ItemPkt> findByItemPktCode(String code);

	ItemPkt one(Long id);

	ItemPkt insert(ItemPkt newObj);

	ItemPkt replace(ItemPkt newObj, Long id);

	void delete(Long id);
}
