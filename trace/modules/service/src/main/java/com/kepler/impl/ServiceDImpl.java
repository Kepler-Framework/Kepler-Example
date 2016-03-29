package com.kepler.impl;

import com.kepler.ServiceD;
import com.kepler.annotation.Autowired;

@Autowired
public class ServiceDImpl implements ServiceD {

	@Override
	public void doD() throws Exception {
		Thread.sleep(10);
	}

}
