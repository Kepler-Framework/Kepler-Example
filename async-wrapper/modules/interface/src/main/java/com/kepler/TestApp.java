package com.kepler;

import java.util.concurrent.Future;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-async")
public interface TestApp {

	public Future<String> test(String url) throws Exception;
}
