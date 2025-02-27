package com.pocket.kingin.domain;

import java.util.List;

public interface ItemObtService {
	List<ItemObt> all();

	ItemObt one(Long id);

	ItemObt insert(ItemObt newObj);

	ItemObt replace(ItemObt newObj, Long id);

	void delete(Long id);
}
