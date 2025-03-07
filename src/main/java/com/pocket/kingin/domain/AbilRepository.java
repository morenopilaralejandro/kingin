package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilRepository extends JpaRepository<Abil, Long> {
	List<Abil> findByAbilCode(String code);
	
	List<Abil> findByAbilNameEnContainingIgnoreCase(String abilNameEn);
	
	List<Abil> findByAbilNameJaContainingIgnoreCase(String abilNameJa);
}
