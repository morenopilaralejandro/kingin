package com.pocket.kingin.domain;

import java.util.List;

public interface StatService {
	List<Stat> all();

	Stat one(Long id);

	Stat insert(Stat newObj);

	Stat replace(Stat newObj, Long id);

	void delete(Long id);
}
