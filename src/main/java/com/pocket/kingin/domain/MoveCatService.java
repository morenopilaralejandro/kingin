package com.pocket.kingin.domain;

import java.util.List;

public interface MoveCatService {
	List<MoveCat> all();

	MoveCat one(Long id);

	MoveCat insert(MoveCat newObj);

	MoveCat replace(MoveCat newObj, Long id);

	void delete(Long id);
}
