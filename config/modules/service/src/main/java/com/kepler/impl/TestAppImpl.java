package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Config;

@Autowired
public class TestAppImpl implements TestApp {

	private String name;

	@Config(value = "name", init = true)
	public void name(String name) {
		this.name = name;
	}

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler + " from " + this.name;
	}
}
