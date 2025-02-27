package com.pocket.kingin.domain;

public class NpcNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NpcNotFoundException(Long id) {
		super("Could not find Npc " + id);
	}
}
