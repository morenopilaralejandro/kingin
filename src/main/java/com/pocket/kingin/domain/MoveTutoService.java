package com.pocket.kingin.domain;

import java.util.List;

public interface MoveTutoService {
	List<MoveTuto> all();

	MoveTuto one(Long id);

	MoveTuto insert(MoveTuto newObj);

	MoveTuto replace(MoveTuto newObj, Long id);

	void delete(Long id);
}
