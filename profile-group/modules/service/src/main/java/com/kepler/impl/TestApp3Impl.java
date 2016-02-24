package com.kepler.impl;

import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp3Impl implements TestApp3 {

	public String test(String kepler) throws Exception {
		Thread.sleep(5000);
		return "Hello world " + kepler;
	}
}
