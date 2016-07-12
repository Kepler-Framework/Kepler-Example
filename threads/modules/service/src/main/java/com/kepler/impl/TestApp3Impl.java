package com.kepler.impl;

import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;
import com.kepler.header.HeadersContext;

@Autowired
public class TestApp3Impl implements TestApp3 {

	private final HeadersContext context;

	public TestApp3Impl(HeadersContext context) {
		super();
		this.context = context;
	}

	public String test(final String kepler) throws Exception {
		return this.context.get().get().toString();
	}
}
