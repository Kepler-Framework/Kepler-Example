package com.kepler.impl;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp1;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.domain1.User;
import com.kepler.domain1.UserRole;

@Autowired
public class TestApp1Impl implements TestApp1 {

	private static final Log LOGGER = LogFactory.getLog(TestApp1Impl.class);

	@Generic
	public User test(String param1, Date param2, long param3, UserRole param4, User param5) throws Exception {
		TestApp1Impl.LOGGER.info(param1);
		TestApp1Impl.LOGGER.info(param2);
		TestApp1Impl.LOGGER.info(param3);
		TestApp1Impl.LOGGER.info(param4);
		return param5;
	}

	@Generic
	public User[] test(String[] param1, Date[] param2, long[] param3, UserRole[] param4, User[] param5) throws Exception {
		TestApp1Impl.LOGGER.info(Arrays.toString(param1));
		TestApp1Impl.LOGGER.info(Arrays.toString(param2));
		TestApp1Impl.LOGGER.info(Arrays.toString(param3));
		TestApp1Impl.LOGGER.info(Arrays.toString(param4));
		return param5;
	}

	@Generic
	public User[] test(String[] param1, Date[] param2, Long[] param3, UserRole[] param4, User[] param5) throws Exception {
		TestApp1Impl.LOGGER.info(Arrays.toString(param1));
		TestApp1Impl.LOGGER.info(Arrays.toString(param2));
		TestApp1Impl.LOGGER.info(Arrays.toString(param3));
		TestApp1Impl.LOGGER.info(Arrays.toString(param4));
		return param5;
	}
}
