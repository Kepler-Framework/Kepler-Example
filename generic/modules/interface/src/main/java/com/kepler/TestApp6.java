package com.kepler;

import com.kepler.annotation.Service;
import com.kepler.domain6.User;
import com.kepler.domain6.impl.UserImpl;

@Service(version = "0.0.1-generic")
public interface TestApp6 {

	public UserImpl test1(UserImpl userImpl);
	
	public User test2(User user);
}
