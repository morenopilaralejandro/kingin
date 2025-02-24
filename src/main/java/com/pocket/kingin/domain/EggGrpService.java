package com.pocket.kingin.domain;

import java.util.List;

public interface EggGrpService {
	List<EggGrp> all();

	EggGrp one(Long id);

	EggGrp insert(EggGrp newObj);

	EggGrp replace(EggGrp newObj, Long id);

	void delete(Long id);
}
