package com.pocket.kingin.domain;

import java.util.List;

public interface PwCrseService {
	List<PwCrse> all();
	
	List<PwCrse> findByPwCrseCode(String code);
	
	List<PwCrse> findByPwCrseNameEnContainingIgnoreCase(String pwCrseNameEn);
	
	List<PwCrse> findBypwCrseNameJaContainingIgnoreCase(String pwCrseNameJa);

	PwCrse one(Long id);

	PwCrse insert(PwCrse newObj);

	PwCrse replace(PwCrse newObj, Long id);

	void delete(Long id);
}
