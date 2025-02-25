package com.pocket.kingin.domain;

import java.util.List;

public interface ShopService {
	List<Shop> all();

	Shop one(Long id);

	Shop insert(Shop newObj);

	Shop replace(Shop newObj, Long id);

	void delete(Long id);
}
