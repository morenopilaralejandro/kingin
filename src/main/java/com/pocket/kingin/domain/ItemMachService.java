package com.pocket.kingin.domain;

import java.util.List;

public interface ItemMachService {
	List<ItemMach> all();

	ItemMach one(Long id);

	ItemMach insert(ItemMach newObj);

	ItemMach replace(ItemMach newObj, Long id);

	void delete(Long id);
}
