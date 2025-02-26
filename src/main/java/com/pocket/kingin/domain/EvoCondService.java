package com.pocket.kingin.domain;

import java.util.List;

public interface EvoCondService {
	List<EvoCond> all();

	EvoCond one(Long id);

	EvoCond insert(EvoCond newObj);

	EvoCond replace(EvoCond newObj, Long id);

	void delete(Long id);
}
