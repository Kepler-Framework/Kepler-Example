package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-server3")
public interface TestApp3 {

	public String test(String kepler) throws Exception;
}
