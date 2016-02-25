package com.kepler.demo;

import com.kepler.invoker.forkjoin.Joiner;

public class MyJoiner implements Joiner {

	@Override
	public Object join(Object current, Object joined) {
		return joined;
	}

	@Override
	public String name() {
		return "my.joiner";
	}

}
