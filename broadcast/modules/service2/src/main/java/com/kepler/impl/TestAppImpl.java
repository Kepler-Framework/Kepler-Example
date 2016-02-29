package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	public void test(String kepler) throws Exception {
		System.out.println("Hello world 2 " + kepler);
	}
}
