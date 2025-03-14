package com.pocket.kingin.domain;

import java.util.List;

public interface PdService {
	List<Pd> all();
	
	List<Pd> findByPdCode(String code);
	
	List<Pd> findByPdNameEnContainingIgnoreCase(String pdNameEn);
	
	List<Pd> findByPdNameJaContainingIgnoreCase(String pdNameJa);

	Pd one(Long id);

	Pd insert(Pd newObj);

	Pd replace(Pd newObj, Long id);

	void delete(Long id);
}
