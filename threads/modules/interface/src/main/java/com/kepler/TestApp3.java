package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-threads")
public interface TestApp3 {

	public String test(String kepler) throws Exception;
}
