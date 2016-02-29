package com.kepler;

import com.kepler.annotation.Broadcast;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-broadcast")
public interface TestApp {

	@Broadcast
	public void test(String kepler) throws Exception;
}
