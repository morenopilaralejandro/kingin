package com.pocket.kingin.domain;

import java.util.List;

public interface EncService {
	List<Enc> all();

	Enc one(Long id);

	Enc insert(Enc newObj);

	Enc replace(Enc newObj, Long id);

	void delete(Long id);
}
