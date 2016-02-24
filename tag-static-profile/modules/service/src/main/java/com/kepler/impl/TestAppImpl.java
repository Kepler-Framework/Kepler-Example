package com.kepler.impl;

import com.kepler.TestApp1;
import com.kepler.annotation.Autowired;
import com.kepler.host.Host;

@Autowired
public class TestAppImpl implements TestApp1 {

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler + " " + Host.TAG_VAL;
	}
}
