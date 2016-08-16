package com.kepler.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.domain2.User;
import com.kepler.domain2.UserRole;

@Autowired
public class TestApp2Impl implements TestApp2 {

	private static final Log LOGGER = LogFactory.getLog(TestApp2Impl.class);

	@Override
	@Generic
	public Collection<User> test1(List<String> param1, List<Date> param2, List<Long> param3, List<UserRole> param4, List<User> param5) throws Exception {
		TestApp2Impl.LOGGER.info(param1);
		TestApp2Impl.LOGGER.info(param2);
		TestApp2Impl.LOGGER.info(param3);
		TestApp2Impl.LOGGER.info(param4);
		return param5;
	}

	@Generic
	public Collection<User> test2(ArrayList<String> param1, CopyOnWriteArrayList<Date> param2, List<Long> param3, List<UserRole> param4, LinkedList<User> param5) throws Exception {
		TestApp2Impl.LOGGER.info(param1);
		TestApp2Impl.LOGGER.info(param2);
		TestApp2Impl.LOGGER.info(param3);
		TestApp2Impl.LOGGER.info(param4);
		return param5;
	}
}
