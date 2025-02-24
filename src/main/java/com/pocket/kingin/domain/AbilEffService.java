package com.pocket.kingin.domain;

import java.util.List;

public interface AbilEffService {
	List<AbilEff> all();

	AbilEff one(Long id);

	AbilEff insert(AbilEff newObj);

	AbilEff replace(AbilEff newObj, Long id);

	void delete(Long id);
}
