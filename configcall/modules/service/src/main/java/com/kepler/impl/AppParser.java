package com.kepler.impl;

import com.kepler.App;
import com.kepler.config.ConfigParser;

public class AppParser implements ConfigParser {

	@Override
	public Object parse(Class<?> request, String config) {
		return new App(config);
	}

	@Override
	public boolean support(Class<?> request) {
		return request.equals(App.class);
	}
}
