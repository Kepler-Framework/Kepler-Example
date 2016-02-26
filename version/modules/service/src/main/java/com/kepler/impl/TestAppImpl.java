package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired(version = { "0.0.1-version", "0.0.2-version" })
public class TestAppImpl implements TestApp {

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler;
	}
}
