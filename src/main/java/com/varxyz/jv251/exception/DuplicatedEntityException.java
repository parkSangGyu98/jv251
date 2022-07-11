package com.varxyz.jv251.exception;

@SuppressWarnings("serial")
public class DuplicatedEntityException extends RuntimeException {
	public DuplicatedEntityException(String msg) {
		super(msg);
	}
}

