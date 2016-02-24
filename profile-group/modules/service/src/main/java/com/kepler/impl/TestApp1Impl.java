package com.kepler.impl;

import com.kepler.TestApp1;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp1Impl implements TestApp1 {

	public String test(String kepler) throws Exception {
		Thread.sleep(5000);
		return "Hello world " + kepler;
	}
}
