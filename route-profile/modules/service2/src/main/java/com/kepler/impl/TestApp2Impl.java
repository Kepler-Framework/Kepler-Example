package com.kepler.impl;

import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;
import com.kepler.host.impl.ServerHost;

@Autowired
public class TestApp2Impl implements TestApp2 {

	private final ServerHost host;

	public TestApp2Impl(ServerHost host) {
		super();
		this.host = host;
	}

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler + ", " + this.host.pid();
	}
}
