package com.pocket.kingin.domain;

public class NpcTitleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NpcTitleNotFoundException(Long id) {
		super("Could not find NpcTitle " + id);
	}
}
