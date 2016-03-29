package com.kepler.impl;

import javax.annotation.Resource;

import com.kepler.ServiceB;
import com.kepler.ServiceC;

@com.kepler.annotation.Autowired
public class ServiceBImpl implements ServiceB {

	@Resource(name="c")
	ServiceC serviceC;
	
	@Override
	public void doB() throws Exception {
		Thread.sleep(10);
		serviceC.doC();
	}

}
