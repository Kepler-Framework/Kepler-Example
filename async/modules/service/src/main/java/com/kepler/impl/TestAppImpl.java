package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	public void test(String kepler) throws Exception {
		Thread.sleep(10000);
		System.out.println("Hello world " + kepler);
	}
}
