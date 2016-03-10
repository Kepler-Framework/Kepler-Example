package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-configcall")
public interface TestApp {

	public App test(String kepler) throws Exception;
}
