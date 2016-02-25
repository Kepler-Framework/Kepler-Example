package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-validation")
public interface TestApp {

	public String test(TestDemo kepler) throws Exception;
}
