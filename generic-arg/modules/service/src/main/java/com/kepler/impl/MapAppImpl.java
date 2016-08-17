package com.kepler.impl;

import java.util.Date;
import java.util.Map;

import com.kepler.MapApp;
import com.kepler.annotation.Autowired;
import com.kepler.map.Cities;
import com.kepler.map.Level;
import com.kepler.map.User;

/**
 * @author KimShen
 *
 */
@Autowired
public class MapAppImpl implements MapApp {

	@Override
	public String test1(Map<String, Date> dates, Map<String, User> users) throws Exception {
		return "[dates=" + dates + "][users=" + users + "]";
	}

	@Override
	public String test2(Map<User, Level> users, Cities cities) throws Exception {
		return "[users=" + users + "][cities=" + cities + "]";
	}
}
