package com.pocket.kingin.domain;

import java.util.List;

public interface CurrService {
	List<Curr> all();

	Curr one(Long id);

	Curr insert(Curr newObj);

	Curr replace(Curr newObj, Long id);

	void delete(Long id);
}
