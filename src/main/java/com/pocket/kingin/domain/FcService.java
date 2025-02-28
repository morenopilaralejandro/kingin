package com.pocket.kingin.domain;

import java.util.List;

public interface FcService {
	List<Fc> all();

	Fc one(Long id);

	Fc insert(Fc newObj);

	Fc replace(Fc newObj, Long id);

	void delete(Long id);
}
