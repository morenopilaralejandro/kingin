package com.pocket.kingin.domain;

import java.util.List;

public interface NpcTitleService {
	List<NpcTitle> all();

	NpcTitle one(Long id);

	NpcTitle insert(NpcTitle newObj);

	NpcTitle replace(NpcTitle newObj, Long id);

	void delete(Long id);
}
