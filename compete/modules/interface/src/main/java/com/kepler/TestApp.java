package com.kepler;

import com.kepler.annotation.Compete;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-compete")
public interface TestApp {

	@Compete(span = 2)
	public String test(String kepler) throws Exception;
}
