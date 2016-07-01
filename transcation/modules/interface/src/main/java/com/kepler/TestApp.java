package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-transcation")
public interface TestApp {

	public String test1(String uuid, String kepler) throws Exception;

	public String test2(String uuid, String kepler) throws Exception;

	public String test3(String uuid, String kepler) throws Exception;
}
