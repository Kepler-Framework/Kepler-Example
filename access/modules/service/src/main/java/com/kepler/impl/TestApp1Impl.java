package com.kepler.impl;

import com.kepler.TestApp1;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp1Impl implements TestApp1 {

	public String test1(String kepler) throws Exception {
		return "Hello world " + kepler;
	}

	public String test2(String kepler) throws Exception {
		return "Hello world " + kepler;
	}
}
