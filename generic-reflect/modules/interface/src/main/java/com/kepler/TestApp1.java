package com.kepler;

import java.util.Date;

import com.kepler.annotation.Service;
import com.kepler.domain1.User;
import com.kepler.domain1.UserRole;

@Service(version = "0.0.1-generic")
public interface TestApp1 {

	public User test1(String param1, Date param2, long param3, UserRole param4, User param5) throws Exception;

	public User[] test2(String[] param1, Date[] param2, long[] param3, UserRole[] param4, User[] param5) throws Exception;

	public User[] test3(String[] param1, Date[] param2, Long[] param3, UserRole[] param4, User[] param5) throws Exception;
}
