package com.kepler.impl;

import com.kepler.TestApp2;
import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;
import com.kepler.host.Host;

@Autowired
public class TestApp2Impl implements TestApp2 {

	private final TestApp3 test3;

	public TestApp2Impl(TestApp3 test3) {
		super();
		this.test3 = test3;
	}

	public String test(String kepler) throws Exception {
		return "Hello world(2) " + Host.TAG_VAL + ", " + this.test3.test(kepler);
	}
}
