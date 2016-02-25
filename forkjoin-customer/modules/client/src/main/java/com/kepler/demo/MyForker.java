package com.kepler.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.invoker.forkjoin.Forker;

public class MyForker implements Forker {

	private final static Log LOGGER = LogFactory.getLog(MyForker.class);

	@Override
	public Object[] fork(Object[] args, String tag, int index) {
		MyForker.LOGGER.warn("Using myforker ...");
		return args;
	}

	@Override
	public String name() {
		return "my.forker";
	}
}
