package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-profile2")
public interface TestApp2 {

	public String test(String kepler) throws Exception;
}
