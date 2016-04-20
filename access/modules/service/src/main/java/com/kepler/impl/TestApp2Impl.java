package com.kepler.impl;

import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;

@Autowired
public class TestApp2Impl implements TestApp2 {

	public String test1(String kepler) throws Exception {
		return "Hello world " + kepler;
	}

	public String test2(String kepler) throws Exception {
		return "Hello world " + kepler;
	}
}
