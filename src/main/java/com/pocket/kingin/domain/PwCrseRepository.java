package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PwCrseRepository extends JpaRepository<PwCrse, Long> {
	List<PwCrse> findByPwCrseCode(String code);
	
	List<PwCrse> findByPwCrseNameEnContainingIgnoreCase(String pwCrseNameEn);
	
	List<PwCrse> findBypwCrseNameJaContainingIgnoreCase(String pwCrseNameJa);
}
