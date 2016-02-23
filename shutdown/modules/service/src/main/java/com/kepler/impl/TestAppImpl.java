package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	public String test(String kepler) throws Exception {
		// 线程休眠45秒
		Thread.sleep(45000);
		return "Hello world " + kepler;
	}
}
