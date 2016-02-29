package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	public String test(String kepler) throws Exception {
		Thread.sleep(1000);
		return "Hello world " + kepler;
	}
}
