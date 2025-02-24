package com.pocket.kingin.domain;

import java.util.List;

public interface MoveMthdService {
	List<MoveMthd> all();

	MoveMthd one(Long id);

	MoveMthd insert(MoveMthd newObj);

	MoveMthd replace(MoveMthd newObj, Long id);

	void delete(Long id);
}
