package com.pocket.kingin.domain;

import java.util.List;

public interface GearTimeService {
	List<GearTime> all();

	GearTime one(Long id);

	GearTime insert(GearTime newObj);

	GearTime replace(GearTime newObj, Long id);

	void delete(Long id);
}
