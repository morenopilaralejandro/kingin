package com.pocket.kingin.domain;

import java.util.List;

public interface VrsService {
	List<Vrs> all();

	Vrs one(Long id);

	Vrs insert(Vrs newObj);

	Vrs replace(Vrs newObj, Long id);

	void delete(Long id);
}
