package com.kepler.impl;

import com.kepler.App;
import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Config;

@Autowired
public class TestAppImpl implements TestApp {

	private App app = new App("Hello ... ");

	@Config(value = "prefix")
	public void setPrefix(App app) {
		this.app = app;
	}

	public App test(String kepler) throws Exception {
		return this.app;
	}
}
