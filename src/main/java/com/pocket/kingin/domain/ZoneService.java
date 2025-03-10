package com.pocket.kingin.domain;

import java.util.List;

public interface ZoneService {
	List<Zone> all();
	
	List<Zone> findByZoneCode(String code);
	
	List<Zone> findByZoneMain(Zone zoneMain);
	
	List<Zone> findByNameEn(String zoneNameEn);
	
	List<Zone> findByNameJa(String zoneNameJa);

	Zone one(Long id);

	Zone insert(Zone newObj);

	Zone replace(Zone newObj, Long id);

	void delete(Long id);
}
