package com.kepler;

import java.util.Date;
import java.util.List;

import com.kepler.annotation.Service;
import com.kepler.list.Members;
import com.kepler.list.Role;

@Service(version = "0.0.1-generic-arg")
public interface ListApp {

	public String test1(String kepler, Date date) throws Exception;

	public String test2(String kepler, List<String> name, List<Role> roles) throws Exception;

	public String test3(String kepler, List<String> name, Members members) throws Exception;
}
