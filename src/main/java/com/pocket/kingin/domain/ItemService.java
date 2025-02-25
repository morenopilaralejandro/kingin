package com.pocket.kingin.domain;

import java.util.List;

public interface ItemService {
	List<Item> all();

	Item one(Long id);

	Item insert(Item newObj);

	Item replace(Item newObj, Long id);

	void delete(Long id);
}
