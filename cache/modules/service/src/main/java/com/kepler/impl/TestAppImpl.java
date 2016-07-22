package com.kepler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	private static final Log LOGGER = LogFactory.getLog(TestAppImpl.class);

	public String test1() throws Exception {
		TestAppImpl.LOGGER.info("Invoke test1 ... ");
		return "Hello world 1 ";
	}

	public String test2() throws Exception {
		TestAppImpl.LOGGER.info("Invoke test2 ... ");
		return "Hello world 2 ";
	}

	public String test3() throws Exception {
		TestAppImpl.LOGGER.info("Invoke test3 ... ");
		return "Hello world 3 ";
	}
}
