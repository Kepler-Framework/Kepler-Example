package com.kepler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.main.Demotion;

@Autowired
public class TestAppImpl implements TestApp, Demotion {

	private final static Log LOGGER = LogFactory.getLog(TestAppImpl.class);

	public String test(String kepler) throws Exception {
		return "Hello world " + kepler;
	}

	@Override
	public void demote() throws Exception {
		TestAppImpl.LOGGER.warn("Demote ... ");
	}
}
