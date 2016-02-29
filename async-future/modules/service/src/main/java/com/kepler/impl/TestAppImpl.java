package com.kepler.impl;

import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.kepler.TestApp;
import com.kepler.annotation.Autowired;
import com.kepler.org.apache.commons.io.IOUtils;

@Autowired
public class TestAppImpl implements TestApp {

	private ExecutorService executor = Executors.newFixedThreadPool(10);

	public Future<String> test(String url) throws Exception {
		return this.executor.submit(new Spider(url));
	}

	private class Spider implements Callable<String> {

		private final String url;

		public Spider(String url) {
			super();
			this.url = url;
		}

		@Override
		public String call() throws Exception {
			return IOUtils.toString(new URL(this.url).openStream());
		}
	}
}
