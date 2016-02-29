package com.kepler.impl;

import java.net.URL;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.org.apache.commons.io.IOUtils;

@Autowired
public class TestAppImpl implements TestApp {

	public String test(String url) throws Exception {
		return IOUtils.toString(new URL(url).openStream());
	}
}
