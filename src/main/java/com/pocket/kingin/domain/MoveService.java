package com.pocket.kingin.domain;

import java.util.List;

public interface MoveService {
	List<Move> all();

	Move one(Long id);

	Move insert(Move newObj);

	Move replace(Move newObj, Long id);

	void delete(Long id);
}
