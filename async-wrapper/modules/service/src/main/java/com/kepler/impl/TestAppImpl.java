package com.kepler.impl;

import java.net.URL;
import java.util.concurrent.Future;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.org.apache.commons.io.IOUtils;
import com.kepler.thread.FutureWrapper;

@Autowired
public class TestAppImpl implements TestApp {

	public Future<String> test(String url) throws Exception {
		return new FutureWrapper<String>(IOUtils.toString(new URL(url).openStream()));
	}
}
