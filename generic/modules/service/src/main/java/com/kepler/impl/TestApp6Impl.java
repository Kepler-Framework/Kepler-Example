package com.kepler.impl;

import com.kepler.TestApp6;
import com.kepler.annotation.Autowired;
import com.kepler.annotation.Generic;
import com.kepler.annotation.GenericParam;
import com.kepler.domain6.User;
import com.kepler.domain6.impl.UserImpl;

@Autowired
public class TestApp6Impl implements TestApp6 {

	@Override
	@Generic
	public UserImpl test1(UserImpl userImpl) {
		return userImpl;
	}

	@Override
	@Generic
	public User test2(@GenericParam({ UserImpl.class }) User user) {
		return user;
	}
}
