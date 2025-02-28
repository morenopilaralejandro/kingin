package com.pocket.kingin.domain;

import java.util.List;

public interface UsrService {
	List<Usr> all();

	Usr one(Long id);

	Usr insert(Usr newObj);

	Usr replace(Usr newObj, Long id);

	void delete(Long id);
}
