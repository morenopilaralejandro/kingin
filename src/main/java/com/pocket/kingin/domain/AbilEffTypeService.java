package com.pocket.kingin.domain;

import java.util.List;

public interface AbilEffTypeService {
	List<AbilEffType> all();

	AbilEffType one(Long id);

	AbilEffType insert(AbilEffType newObj);

	AbilEffType replace(AbilEffType newObj, Long id);

	void delete(Long id);
}
