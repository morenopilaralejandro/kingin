package com.pocket.kingin.domain;

import java.util.List;

public interface GndrService {
	List<Gndr> all();

	Gndr one(Long id);

	Gndr insert(Gndr newObj);

	Gndr replace(Gndr newObj, Long id);

	void delete(Long id);
}
