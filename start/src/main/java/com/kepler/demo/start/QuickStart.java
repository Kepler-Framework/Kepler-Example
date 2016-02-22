package com.kepler.demo.start;

import com.kepler.annotation.Service;

@Service(version = "0.0.1")
public interface QuickStart {

	public HelloWorld hi(String name);
}
