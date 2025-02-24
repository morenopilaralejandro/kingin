package com.pocket.kingin.domain;

import java.util.List;

public interface MoveTrgtService {
	List<MoveTrgt> all();

	MoveTrgt one(Long id);

	MoveTrgt insert(MoveTrgt newObj);

	MoveTrgt replace(MoveTrgt newObj, Long id);

	void delete(Long id);
}
