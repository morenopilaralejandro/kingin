package com.pocket.kingin.domain;

import java.util.List;

public interface GearCallService {
	List<GearCall> all();

	GearCall one(Long id);

	GearCall insert(GearCall newObj);

	GearCall replace(GearCall newObj, Long id);

	void delete(Long id);
}
