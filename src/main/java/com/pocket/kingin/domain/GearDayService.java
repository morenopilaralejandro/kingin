package com.pocket.kingin.domain;

import java.util.List;

public interface GearDayService {
	List<GearDay> all();

	GearDay one(Long id);

	GearDay insert(GearDay newObj);

	GearDay replace(GearDay newObj, Long id);

	void delete(Long id);
}
