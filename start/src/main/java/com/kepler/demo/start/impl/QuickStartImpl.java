package com.kepler.demo.start.impl;

import com.kepler.annotation.Autowired;
import com.kepler.demo.start.HelloWorld;
import com.kepler.demo.start.QuickStart;

@Autowired
public class QuickStartImpl implements QuickStart {

	public HelloWorld hi(String name) {
		return new HelloWorldImpl(name);
	}

}
