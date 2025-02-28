package com.pocket.kingin.domain;

import java.util.List;

public interface PoService {
	List<Po> all();

	Po one(Long id);

	Po insert(Po newObj);

	Po replace(Po newObj, Long id);

	void delete(Long id);
}
