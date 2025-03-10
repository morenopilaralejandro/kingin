package com.pocket.kingin.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
	List<Zone> findByZoneCode(String code);
	
	List<Zone> findByZoneMain(Zone zoneMain);
	
	@Query( value =
			"select z from zone z " +
			"join zone_name zn " +
			"on z.zone_name_id=zn.zone_name_id " +
			"where lower(zn.zone_name_en) like lower('%?1%') " +
			"and z.zone_main_id is null", nativeQuery = true)
	List<Zone> findByNameEn(String zoneNameEn);
	
	@Query( value =
			"select z from zone z " +
			"join zone_name zn " +
			"on z.zone_name_id=zn.zone_name_id " +
			"where lower(zn.zone_name_ja) like lower('%?1%') " +
			"and z.zone_main_id is null" , nativeQuery = true)
	List<Zone> findByNameJa(String zoneNameJa);

}
