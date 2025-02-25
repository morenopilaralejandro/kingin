package com.pocket.kingin.domain;

import java.util.List;

public interface ZoneNameService {
	List<ZoneName> all();

	ZoneName one(Long id);

	ZoneName insert(ZoneName newObj);

	ZoneName replace(ZoneName newObj, Long id);

	void delete(Long id);
}
