package com.kepler.impl;

import java.util.Arrays;
import java.util.Date;

import com.kepler.ArrayApp;
import com.kepler.annotation.Autowired;
import com.kepler.array.Members;
import com.kepler.array.Role;

@Autowired
public class ArrayAppImpl implements ArrayApp {

	public String test1(String kepler, Date date) throws Exception {
		return "Hello world " + kepler + " " + date;
	}

	public String test2(String kepler, String[] name, Role[] roles) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(Arrays.toString(name)).append(Arrays.toString(roles));
		return buffer.toString();
	}

	public String test3(String kepler, String[] name, Members members) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(Arrays.toString(name)).append(members);
		return buffer.toString();
	}
}
