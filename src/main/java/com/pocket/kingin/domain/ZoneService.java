package com.pocket.kingin.domain;

import java.util.List;

public interface ZoneService {
	List<Zone> all();

	Zone one(Long id);

	Zone insert(Zone newObj);

	Zone replace(Zone newObj, Long id);

	void delete(Long id);
}
