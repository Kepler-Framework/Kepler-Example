package com.kepler;

import java.util.Collection;

import com.kepler.annotation.ForkJoin;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-forkjoin")
public interface TestApp {

	@ForkJoin(fork = "equals", join = "complex")
	public Collection<String> test(String kepler) throws Exception;
}
