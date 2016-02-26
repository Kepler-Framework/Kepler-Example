package com.kepler.impl;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.host.impl.ServerHost;

@Autowired
public class TestAppImpl implements TestApp {

	private final ServerHost host;

	public TestAppImpl(ServerHost host) {
		super();
		this.host = host;
	}

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler + ", " + this.host.pid();
	}
}
