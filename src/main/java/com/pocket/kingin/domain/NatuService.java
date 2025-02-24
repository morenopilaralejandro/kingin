package com.pocket.kingin.domain;

import java.util.List;

public interface NatuService {
	List<Natu> all();

	Natu one(Long id);

	Natu insert(Natu newObj);

	Natu replace(Natu newObj, Long id);

	void delete(Long id);
}
