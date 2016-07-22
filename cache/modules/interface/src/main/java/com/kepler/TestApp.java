package com.kepler;

import com.kepler.annotation.Cached;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-cache")
public interface TestApp {

	@Cached
	public String test1() throws Exception;

	@Cached
	public String test2() throws Exception;

	@Cached
	public String test3() throws Exception;
}
