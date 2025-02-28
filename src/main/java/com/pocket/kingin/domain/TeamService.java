package com.pocket.kingin.domain;

import java.util.List;

public interface TeamService {
	List<Team> all();

	Team one(Long id);

	Team insert(Team newObj);

	Team replace(Team newObj, Long id);

	void delete(Long id);
}
