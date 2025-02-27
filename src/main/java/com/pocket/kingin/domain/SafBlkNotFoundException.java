package com.pocket.kingin.domain;

public class SafBlkNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SafBlkNotFoundException(Long id) {
		super("Could not find SafBlk " + id);
	}
}
