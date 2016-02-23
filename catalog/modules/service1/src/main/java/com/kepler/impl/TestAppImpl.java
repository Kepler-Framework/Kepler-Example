package com.kepler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired(catalog = "token")
public class TestAppImpl implements TestApp {

	private final static Log LOGGER = LogFactory.getLog(TestAppImpl.class);

	public String test(String kepler) throws Exception {
		TestAppImpl.LOGGER.info("Token is " + kepler);
		return kepler + " filter by token, ";
	}
}
