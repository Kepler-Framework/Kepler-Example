package com.kepler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp5;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.domain5.User;

@Autowired
public class TestApp5Impl implements TestApp5 {

	private static final Log LOGGER = LogFactory.getLog(TestApp5Impl.class);

	@Override
	@Generic
	public User test1(User user) {
		return user;
	}

	@Override
	@Generic
	public void test2(User user) {
		TestApp5Impl.LOGGER.info(user);
	}

	@Override
	@Generic
	public User test3() {
		return new User();
	}
}
