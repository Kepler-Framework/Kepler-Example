package com.kepler.impl;

import java.net.URL;

import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;
import com.kepler.org.apache.commons.io.IOUtils;

@Autowired
public class TestApp2Impl implements TestApp2 {

	public String test(String url) throws Exception {
		Thread.sleep(5000);
		return IOUtils.toString(new URL(url).openStream());
	}
}
