package com.kepler.impl;

import java.util.Arrays;
import java.util.Collection;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	public Collection<String> test(String kepler) throws Exception {
		return Arrays.asList("k", "e");
	}
}
