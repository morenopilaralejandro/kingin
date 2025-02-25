package com.pocket.kingin.domain;

import java.util.List;

public interface ItemCatService {
	List<ItemCat> all();

	ItemCat one(Long id);

	ItemCat insert(ItemCat newObj);

	ItemCat replace(ItemCat newObj, Long id);

	void delete(Long id);
}
