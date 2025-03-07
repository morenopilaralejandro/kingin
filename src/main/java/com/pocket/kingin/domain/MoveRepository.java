package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepository extends JpaRepository<Move, Long> {
	List<Move> findByMoveCode(String code);
	
	List<Move> findByMoveNameEnContainingIgnoreCase(String moveNameEn);
	
	List<Move> findByMoveNameJaContainingIgnoreCase(String moveNameJa);
	
	List<Move> findAll(Specification<Move> spec);
}
