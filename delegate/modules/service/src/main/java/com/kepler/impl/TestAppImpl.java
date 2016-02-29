package com.kepler.impl;

import com.kepler.TestApp;

public class TestAppImpl implements TestApp {

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler;
	}
}
