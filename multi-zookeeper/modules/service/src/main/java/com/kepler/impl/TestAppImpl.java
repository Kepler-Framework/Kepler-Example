package com.kepler.impl;

import com.kepler.TestApp1;
import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp1 {

	private final TestApp2 test;

	public TestAppImpl(TestApp2 test) {
		super();
		this.test = test;
	}

	public String test(String kepler) throws Exception {
		return "Hello world 1 " + kepler + " on remote zk" + " (" + this.test.test(kepler) + ") ...";
	}
}
