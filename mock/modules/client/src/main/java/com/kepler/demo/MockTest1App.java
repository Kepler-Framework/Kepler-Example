package com.kepler.demo;

import com.kepler.TestApp1;
import com.kepler.mock.Mocker;
import com.kepler.protocol.Request;

public class MockTest1App implements Mocker {

	@Override
	public Object mock(Request request) {
		return "THIS IS MOCK 1 ... ";
	}

	@Override
	public Class<?> support() {
		return TestApp1.class;
	}

}
