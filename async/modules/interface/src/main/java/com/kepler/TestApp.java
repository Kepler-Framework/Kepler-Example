package com.kepler;

import com.kepler.annotation.Async;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-async")
public interface TestApp {

	@Async
	public void test(String kepler) throws Exception;
}
