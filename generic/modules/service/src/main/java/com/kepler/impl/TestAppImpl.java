package com.kepler.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.domain.Apply;
import com.kepler.domain.Signature;
import com.kepler.domain.User;
import com.kepler.domain.impl.ApplyImpl;

@Autowired
public class TestAppImpl implements TestApp {

	private static Log LOGGER = LogFactory.getLog(TestAppImpl.class);

	public Apply submit(String uid, Date time, User user, Signature signature) throws Exception {
		TestAppImpl.LOGGER.info("uid: " + uid);
		TestAppImpl.LOGGER.info("time: " + time);
		TestAppImpl.LOGGER.info("user.id: " + user.getId());
		TestAppImpl.LOGGER.info("user.dept: " + user.getDept());
		TestAppImpl.LOGGER.info("user.roles: " + user.getRoles());
		TestAppImpl.LOGGER.info("user.level: " + user.getLevel());
		TestAppImpl.LOGGER.info("user.address: " + user.getAddresses());
		return new ApplyImpl(System.currentTimeMillis(), user);
	}
}
