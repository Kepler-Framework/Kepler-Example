package com.kepler.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.domain3.User;
import com.kepler.domain3.UserRole;

@Autowired
public class TestApp3Impl implements TestApp3 {

	private static final Log LOGGER = LogFactory.getLog(TestApp3Impl.class);

	@Override
	@Generic
	public Collection<User> test1(Set<String> param1, Set<Date> param2, Set<Long> param3, Set<UserRole> param4, Set<User> param5) throws Exception {
		TestApp3Impl.LOGGER.info(param1);
		TestApp3Impl.LOGGER.info(param2);
		TestApp3Impl.LOGGER.info(param3);
		TestApp3Impl.LOGGER.info(param4);
		return param5;
	}

	@Generic
	public Collection<User> test2(TreeSet<String> param1, CopyOnWriteArraySet<Date> param2, Set<Long> param3, Set<UserRole> param4, HashSet<User> param5) throws Exception {
		TestApp3Impl.LOGGER.info(param1);
		TestApp3Impl.LOGGER.info(param2);
		TestApp3Impl.LOGGER.info(param3);
		TestApp3Impl.LOGGER.info(param4);
		return param5;
	}
}
