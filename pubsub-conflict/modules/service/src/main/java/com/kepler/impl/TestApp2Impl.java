package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp2Impl implements TestApp {

	public String test(String kepler) throws Exception {
		return "Hello world 2 " + kepler;
	}
}
