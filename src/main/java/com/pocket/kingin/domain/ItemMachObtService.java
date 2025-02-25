package com.pocket.kingin.domain;

import java.util.List;

public interface ItemMachObtService {
	List<ItemMachObt> all();

	ItemMachObt one(Long id);

	ItemMachObt insert(ItemMachObt newObj);

	ItemMachObt replace(ItemMachObt newObj, Long id);

	void delete(Long id);
}
