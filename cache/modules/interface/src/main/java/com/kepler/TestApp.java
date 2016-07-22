package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-cache")
public interface TestApp {

	public String test1(String kepler) throws Exception;

	public String test2(String kepler) throws Exception;
	
	public String test3(String kepler) throws Exception;
}
