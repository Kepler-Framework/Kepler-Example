package com.kepler;

import java.io.Serializable;

public class App implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String name;

	public App(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
