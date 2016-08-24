package com.kepler.demo;

import com.kepler.mock.Mocker;
import com.kepler.protocol.Request;

public class MyMocker implements Mocker{

	@Override
	public Object mock(Request request) {
		return "This is MyMocker";
	}

}
