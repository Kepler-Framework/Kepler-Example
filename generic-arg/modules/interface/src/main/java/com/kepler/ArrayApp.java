package com.kepler;

import java.util.Date;

import com.kepler.annotation.Service;
import com.kepler.array.Members;
import com.kepler.array.Role;

@Service(version = "0.0.1-generic-arg")
public interface ArrayApp {

	public String test1(String kepler, Date date) throws Exception;

	public String test2(String kepler, String[] name, Role[] roles) throws Exception;

	public String test3(String kepler, String[] name, Members members) throws Exception;
}
