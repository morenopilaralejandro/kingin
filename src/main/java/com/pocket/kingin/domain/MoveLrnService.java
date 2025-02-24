package com.pocket.kingin.domain;

import java.util.List;

public interface MoveLrnService {
	List<MoveLrn> all();

	MoveLrn one(Long id);

	MoveLrn insert(MoveLrn newObj);

	MoveLrn replace(MoveLrn newObj, Long id);

	void delete(Long id);
}
