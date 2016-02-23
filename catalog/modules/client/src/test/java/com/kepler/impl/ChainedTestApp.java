package com.kepler.impl;

import java.util.List;

import com.kepler.TestApp;

public class ChainedTestApp implements TestApp {

	private final List<TestApp> apps;

	public ChainedTestApp(List<TestApp> apps) {
		super();
		this.apps = apps;
	}

	@Override
	public String test(String kepler) throws Exception {
		String response = kepler;
		for (TestApp each : this.apps) {
			response = each.test(response);
		}
		return response;
	}
}
