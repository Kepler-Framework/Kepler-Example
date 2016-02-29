package com.kepler;

import com.kepler.TestApp2;
import com.kepler.mock.Mocker;
import com.kepler.protocol.Request;

public class MockTest2App implements Mocker {

	@Override
	public Object mock(Request request) {
		return "THIS IS MOCK 2 ... ";
	}

	@Override
	public Class<?> support() {
		return TestApp2.class;
	}
}
