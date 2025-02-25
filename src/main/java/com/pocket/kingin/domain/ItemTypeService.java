package com.pocket.kingin.domain;

import java.util.List;

public interface ItemTypeService {
	List<ItemType> all();

	ItemType one(Long id);

	ItemType insert(ItemType newObj);

	ItemType replace(ItemType newObj, Long id);

	void delete(Long id);
}
