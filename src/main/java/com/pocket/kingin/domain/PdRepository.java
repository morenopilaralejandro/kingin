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
	
	
	@Query( value =
			"select distinct pd.* from pd " +
			"join pd_belo_egg_grp pbe on pd.pd_id=pbe.pd_id " +
			"join pd_lrn_move lpm on pd.pd_id=lpm.pd_id " +
			"where pbe.egg_grp_id in ( " +
				"select egg_grp_id from pd_belo_egg_grp pbe2 " +
				"where pbe2.pd_id = ?1 ) " +
			"and lpm.move_id=?2 " +
			"and lpm.move_lrn_id in (1)" , nativeQuery = true)
	List<Pd> findByEggMoveLv(Long pdId, Long moveId);
	
	@Query( value =
			"select distinct pd.* from pd " +
			"join pd_belo_egg_grp pbe on pd.pd_id=pbe.pd_id " +
			"join pd_lrn_move lpm on pd.pd_id=lpm.pd_id " +
			"where pbe.egg_grp_id in ( " +
				"select egg_grp_id from pd_belo_egg_grp pbe2 " +
				"where pbe2.pd_id = ?1 ) " +
			"and lpm.move_id=?2 " +
			"and lpm.move_lrn_id in (3)" , nativeQuery = true)
	List<Pd> findByEggMoveEg(Long pdId, Long moveId);
	
	
}
