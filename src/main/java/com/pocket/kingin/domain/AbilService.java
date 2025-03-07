package com.pocket.kingin.domain;

import java.util.List;

public interface AbilService {
	List<Abil> all();
	
	List<Abil> findByAbilCode(String code);
	
	List<Abil> findByAbilNameEnContainingIgnoreCase(String abilNameEn);
	
	List<Abil> findByAbilNameJaContainingIgnoreCase(String abilNameJa);

	Abil one(Long id);

	Abil insert(Abil newObj);

	Abil replace(Abil newObj, Long id);

	void delete(Long id);
}
