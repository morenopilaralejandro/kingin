package com.pocket.kingin.domain;

import java.util.List;

public interface SafBlkService {
	List<SafBlk> all();

	SafBlk one(Long id);

	SafBlk insert(SafBlk newObj);

	SafBlk replace(SafBlk newObj, Long id);

	void delete(Long id);
}
