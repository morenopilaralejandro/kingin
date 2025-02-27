package com.pocket.kingin.domain;

import java.util.List;

public interface NpcService {
	List<Npc> all();

	Npc one(Long id);

	Npc insert(Npc newObj);

	Npc replace(Npc newObj, Long id);

	void delete(Long id);
}
