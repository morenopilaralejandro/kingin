package com.pocket.kingin.domain;

import java.util.List;

public interface ExpGrpService {
	List<ExpGrp> all();

	ExpGrp one(Long id);

	ExpGrp insert(ExpGrp newObj);

	ExpGrp replace(ExpGrp newObj, Long id);

	void delete(Long id);
}
