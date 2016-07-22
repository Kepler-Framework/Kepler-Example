package com.kepler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	private static final Log LOGGER = LogFactory.getLog(TestAppImpl.class);

	public String test1(String kepler) throws Exception {
		TestAppImpl.LOGGER.info("Invoke test1 ... " + kepler);
		return "Hello world 1 " + kepler;
	}

	public String test2(String kepler) throws Exception {
		TestAppImpl.LOGGER.info("Invoke test2 ... " + kepler);
		return "Hello world 2 " + kepler;
	}

	public String test3(String kepler) throws Exception {
		TestAppImpl.LOGGER.info("Invoke test3 ... " + kepler);
		return "Hello world 3 " + kepler;
	}
}
