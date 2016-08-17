package com.kepler.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp4;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.domain4.User;
import com.kepler.domain4.UserRole;

@Autowired
public class TestApp4Impl implements TestApp4 {

	private static final Log LOGGER = LogFactory.getLog(TestApp2Impl.class);

	@Override
	@Generic
	public Map<User, User> test1(Map<String, Date> param1, Map<Long, UserRole> param2, Map<User, User> param3) throws Exception {
		TestApp4Impl.LOGGER.info(param1);
		TestApp4Impl.LOGGER.info(param2);
		TestApp4Impl.LOGGER.info(param3);
		return param3;
	}

	@Generic
	public Map<User, User> test2(HashMap<String, Date> param1, Map<Long, UserRole> param2, ConcurrentHashMap<User, User> param3) throws Exception {
		TestApp4Impl.LOGGER.info(param1);
		TestApp4Impl.LOGGER.info(param2);
		TestApp4Impl.LOGGER.info(param3);
		return new HashMap<User, User>(param3);
	}
}
