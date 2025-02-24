package com.pocket.kingin.domain;

import java.util.List;

public interface MoveEffService {
	List<MoveEff> all();

	MoveEff one(Long id);

	MoveEff insert(MoveEff newObj);

	MoveEff replace(MoveEff newObj, Long id);

	void delete(Long id);
}
