package com.kepler.impl;

import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp2Impl implements TestApp2 {

	public String test(String kepler) throws Exception {
		Thread.sleep(5000);
		return "Hello world " + kepler;
	}
}
