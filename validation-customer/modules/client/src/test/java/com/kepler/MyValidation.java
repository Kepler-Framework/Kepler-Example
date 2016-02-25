package com.kepler;

import org.springframework.util.Assert;

import com.kepler.protocol.Request;
import com.kepler.protocol.RequestValidation;

public class MyValidation implements RequestValidation {

	@Override
	public Request valid(Request request) throws KeplerValidateException {
		Assert.notNull(TestDemo.class.cast(request.args()[0]).getName());
		return request;
	}

	@Override
	public Scope scope() {
		return Scope.CLIENT;
	}

}
