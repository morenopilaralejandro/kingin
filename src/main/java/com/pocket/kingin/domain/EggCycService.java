package com.pocket.kingin.domain;

import java.util.List;

public interface EggCycService {
	List<EggCyc> all();

	EggCyc one(Long id);

	EggCyc insert(EggCyc newObj);

	EggCyc replace(EggCyc newObj, Long id);

	void delete(Long id);
}
