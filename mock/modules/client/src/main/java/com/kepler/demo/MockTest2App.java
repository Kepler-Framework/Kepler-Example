package com.kepler.demo;

import com.kepler.TestApp2;
import com.kepler.mock.ServiceMocker;
import com.kepler.protocol.Request;

public class MockTest2App implements ServiceMocker {

	@Override
	public Object mock(Request request) {
		return "THIS IS MOCK 2 ... ";
	}

	@Override
	public Class<?> support() {
		return TestApp2.class;
	}
}
