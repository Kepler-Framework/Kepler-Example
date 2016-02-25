package com.kepler;

import java.util.Collection;

import com.kepler.annotation.ForkJoin;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-forkjoin")
public interface TestApp {

	@ForkJoin(fork = "my.forker", join = "my.joiner")
	public Collection<String> test(String kepler) throws Exception;
}
