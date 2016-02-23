package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-catalog")
public interface TestApp {

	public String test(String kepler) throws Exception;
}
