package com.pocket.kingin.domain;

import java.util.List;

public interface TypeService {
	List<Type> all();

	Type one(Long id);

	Type insert(Type newObj);

	Type replace(Type newObj, Long id);

	void delete(Long id);
}
