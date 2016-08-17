package com.kepler.impl;

import java.util.Date;
import java.util.List;

import com.kepler.ListApp;
import com.kepler.annotation.Autowired;
import com.kepler.list.Members;
import com.kepler.list.Role;

@Autowired
public class ListAppImpl implements ListApp {

	public String test1(String kepler, Date date) throws Exception {
		return "Hello world " + kepler + " " + date;
	}

	public String test2(String kepler, List<String> name, List<Role> roles) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name).append(roles);
		return buffer.toString();
	}

	public String test3(String kepler, List<String> name, Members members) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name).append(members);
		return buffer.toString();
	}
}
