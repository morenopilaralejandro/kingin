package com.pocket.kingin.domain;

import java.util.List;

public interface PwUnlcService {
	List<PwUnlc> all();

	PwUnlc one(Long id);

	PwUnlc insert(PwUnlc newObj);

	PwUnlc replace(PwUnlc newObj, Long id);

	void delete(Long id);
}
