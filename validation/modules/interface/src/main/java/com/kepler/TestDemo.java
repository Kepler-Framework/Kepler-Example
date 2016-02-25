package com.kepler;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TestDemo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private final String name;

	public TestDemo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
