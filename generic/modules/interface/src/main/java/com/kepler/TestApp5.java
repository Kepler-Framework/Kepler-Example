package com.kepler;

import com.kepler.annotation.Service;
import com.kepler.domain5.User;

@Service(version = "0.0.1-generic")
public interface TestApp5 {

	public User test1(User user);
	
	public void test2(User user);
	
	public User test3();
}
