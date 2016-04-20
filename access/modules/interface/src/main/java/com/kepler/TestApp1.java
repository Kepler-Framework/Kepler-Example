package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-access")
public interface TestApp1 {

	public String test1(String kepler) throws Exception;

	public String test2(String kepler) throws Exception;
}
