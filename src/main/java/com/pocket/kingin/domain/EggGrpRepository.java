package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EggGrpRepository extends JpaRepository<EggGrp, Long> {
	List<EggGrp> findByEggGrpCode(String code);
}
