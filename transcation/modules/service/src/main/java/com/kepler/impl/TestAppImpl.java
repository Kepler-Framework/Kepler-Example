package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	private void failed(String kepler, int length) throws Exception {
		if (kepler.length() > length) {
			throw new RuntimeException("Failed length: " + length + " for " + kepler);
		}
	}

	public String test1(String uuid, String kepler) throws Exception {
		this.failed(kepler, 10);
		return "Hello world 1 " + kepler + " (" + uuid + ") ";
	}

	public String test2(String uuid, String kepler) throws Exception {
		this.failed(kepler, 5);
		return "Hello world 2 " + kepler + " (" + uuid + ") ";
	}

	public String test3(String uuid, String kepler) throws Exception {
		return "Hello world 2 " + kepler + " (" + uuid + ") ";
	}
}
