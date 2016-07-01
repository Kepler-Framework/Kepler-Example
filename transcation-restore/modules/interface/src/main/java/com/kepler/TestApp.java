package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-transcation-restore")
public interface TestApp {

	public String test(String uuid, String kepler) throws Exception;
}
