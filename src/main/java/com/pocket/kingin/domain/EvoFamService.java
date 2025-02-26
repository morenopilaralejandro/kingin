package com.pocket.kingin.domain;

import java.util.List;

public interface EvoFamService {
	List<EvoFam> all();

	EvoFam one(Long id);

	EvoFam insert(EvoFam newObj);

	EvoFam replace(EvoFam newObj, Long id);

	void delete(Long id);
}
