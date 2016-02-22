package com.kepler.demo.start.impl;

import java.io.Serializable;

import com.kepler.demo.start.HelloWorld;

public class HelloWorldImpl implements Serializable, HelloWorld {

	private static final long serialVersionUID = 1L;

	private String name;

	public HelloWorldImpl(String name) {
		super();
		this.name = name;
	}

	public String hello() {
		return "Hello " + this.name;
	}
}
