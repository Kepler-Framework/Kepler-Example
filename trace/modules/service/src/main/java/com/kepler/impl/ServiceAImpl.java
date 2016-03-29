package com.kepler.impl;

import javax.annotation.Resource;

import com.kepler.ServiceA;
import com.kepler.ServiceB;
import com.kepler.ServiceD;
import com.kepler.trace.TraceEnabled;
import com.kepler.trace.TraceLogger;

@com.kepler.annotation.Autowired
@TraceLogger(logger = "com.kepler.impl.ServiceAImpl")
public class ServiceAImpl implements ServiceA {

	@Resource(name="b")
	ServiceB B;
	
	@Resource(name="d")
	ServiceD D;
	
	@Override
	@TraceEnabled
	public void doA() throws Exception {
		B.doB();
		D.doD();
	}

}
