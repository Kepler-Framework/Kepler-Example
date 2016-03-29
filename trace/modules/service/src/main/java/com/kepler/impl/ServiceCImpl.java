package com.kepler.impl;

import com.kepler.ServiceC;
import com.kepler.annotation.Autowired;

@Autowired
public class ServiceCImpl implements ServiceC {

	@Override
	public void doC() throws Exception {
		Thread.sleep(10);
	}

}
