package com.pocket.kingin.domain;

import java.util.List;

public interface ItemFossService {
	List<ItemFoss> all();

	ItemFoss one(Long id);

	ItemFoss insert(ItemFoss newObj);

	ItemFoss replace(ItemFoss newObj, Long id);

	void delete(Long id);
}
