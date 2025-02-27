package com.pocket.kingin.domain;

import java.util.List;

public interface PwGrpService {
	List<PwGrp> all();

	PwGrp one(Long id);

	PwGrp insert(PwGrp newObj);

	PwGrp replace(PwGrp newObj, Long id);

	void delete(Long id);
}
