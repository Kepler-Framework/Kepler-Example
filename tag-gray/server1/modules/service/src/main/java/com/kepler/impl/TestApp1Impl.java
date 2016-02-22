package com.kepler.impl;

import com.kepler.TestApp1;
import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;
import com.kepler.host.Host;

@Autowired
public class TestApp1Impl implements TestApp1 {

	private final TestApp2 test2;

	public TestApp1Impl(TestApp2 test2) {
		super();
		this.test2 = test2;
	}

	public String test(String kepler) throws Exception {
		return "Hello world(1) " + Host.TAG_VAL + ", " + this.test2.test(kepler);
	}
}
