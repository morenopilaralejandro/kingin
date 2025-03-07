package com.pocket.kingin.domain;

import java.util.List;

import com.pocket.kingin.form.MoveSearch;

public interface MoveService {
	List<Move> all();
	
	List<Move> findByMoveCode(String code);
	
	List<Move> findByMoveNameEnContainingIgnoreCase(String moveNameEn);
	
	List<Move> findByMoveNameJaContainingIgnoreCase(String moveNameJa);

	List<Move> findByCriteriaMoveSearch(MoveSearch moveSearch, String lang);

	Move one(Long id);

	Move insert(Move newObj);

	Move replace(Move newObj, Long id);

	void delete(Long id);
}
