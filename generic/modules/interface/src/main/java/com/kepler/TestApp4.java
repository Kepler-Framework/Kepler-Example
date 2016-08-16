package com.kepler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.kepler.annotation.Service;
import com.kepler.domain4.User;
import com.kepler.domain4.UserRole;

@Service(version = "0.0.1-generic")
public interface TestApp4 {

	public Map<User, User> test1(Map<String, Date> param1, Map<Long, UserRole> param2, Map<User, User> param3) throws Exception;
	
	public Map<User, User> test2(HashMap<String, Date> param1, Map<Long, UserRole> param2, ConcurrentHashMap<User, User> param3) throws Exception;
}
