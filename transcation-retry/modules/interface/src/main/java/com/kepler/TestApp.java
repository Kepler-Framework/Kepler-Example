package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-transcation-retry")
public interface TestApp {

	public void test1(String uuid, String kepler) throws Exception;

	public void test2(String uuid, String kepler) throws Exception;
}
