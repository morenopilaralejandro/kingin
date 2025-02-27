package com.pocket.kingin.domain;

import java.util.List;

public interface ArtiService {
	List<Arti> all();

	Arti one(Long id);

	Arti insert(Arti newObj);

	Arti replace(Arti newObj, Long id);

	void delete(Long id);
}
