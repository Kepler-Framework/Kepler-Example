package com.kepler.impl;

import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;
import com.kepler.host.Host;

@Autowired
public class TestAppImpl implements TestApp3 {

	public String test(String kepler) throws Exception {
		return "Hello world(3) " + Host.TAG_VAL + ", ";
	}
}
