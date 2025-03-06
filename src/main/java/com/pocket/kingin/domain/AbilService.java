package com.pocket.kingin.domain;

import java.util.List;

public interface AbilService {
	List<Abil> all();

	Abil one(Long id);
	
	List<Abil> findByAbilCode(String code);

	Abil insert(Abil newObj);

	Abil replace(Abil newObj, Long id);

	void delete(Long id);
}
