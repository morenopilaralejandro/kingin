package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PdRepository extends JpaRepository<Pd, Long> {
	List<Pd> findByPdCode(String code);
	
	List<Pd> findByPdNameEnContainingIgnoreCase(String pdNameEn);
	
	List<Pd> findByPdNameJaContainingIgnoreCase(String pdNameJa);
	
	@Query( value =
			"select pd.* from pd " +
			"join pd_lina_evo_fam ple " +
			"on pd.pd_id=ple.pd_id " +
			"where ple.evo_fam_id=?1 " +
			"order by ple.ordr" , nativeQuery = true)
	List<Pd> findByEvoFamId(Long evoFamId);
}
