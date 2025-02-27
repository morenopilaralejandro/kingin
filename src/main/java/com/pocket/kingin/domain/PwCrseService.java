package com.pocket.kingin.domain;

import java.util.List;

public interface PwCrseService {
	List<PwCrse> all();

	PwCrse one(Long id);

	PwCrse insert(PwCrse newObj);

	PwCrse replace(PwCrse newObj, Long id);

	void delete(Long id);
}
