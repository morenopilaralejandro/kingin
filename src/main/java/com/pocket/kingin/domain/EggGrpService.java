package com.pocket.kingin.domain;

import java.util.List;

public interface EggGrpService {
	List<EggGrp> all();

	EggGrp one(Long id);
	
	List<EggGrp> findByEggGrpCode(String code);

	EggGrp insert(EggGrp newObj);

	EggGrp replace(EggGrp newObj, Long id);

	void delete(Long id);
}
