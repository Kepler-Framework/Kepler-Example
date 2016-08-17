package com.kepler;

import java.util.Date;
import java.util.Map;

import com.kepler.annotation.Service;
import com.kepler.map.Cities;
import com.kepler.map.Level;
import com.kepler.map.User;

@Service(version = "0.0.1-generic-arg")
public interface MapApp {

	public String test1(Map<String, Date> dates, Map<String, User> users) throws Exception;
	
	public String test2(Map<User, Level> users, Cities cities) throws Exception;
}
