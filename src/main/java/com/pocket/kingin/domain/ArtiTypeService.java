package com.pocket.kingin.domain;

import java.util.List;

public interface ArtiTypeService {
	List<ArtiType> all();

	ArtiType one(Long id);

	ArtiType insert(ArtiType newObj);

	ArtiType replace(ArtiType newObj, Long id);

	void delete(Long id);
}
