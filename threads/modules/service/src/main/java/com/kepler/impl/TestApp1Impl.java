package com.kepler.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

import com.kepler.TestApp1;
import com.kepler.TestApp2;
import com.kepler.annotation.Autowired;
import com.kepler.header.HeadersContext;

@Autowired
public class TestApp1Impl implements TestApp1 {

	private final HeadersContext context;

	private final Executor executor;

	private final TestApp2 test2;

	public TestApp1Impl(HeadersContext context, Executor executor, TestApp2 test2) {
		super();
		this.test2 = test2;
		this.context = context;
		this.executor = executor;
	}

	public String test(final String kepler) throws Exception {
		this.context.get().put("test-1", "T1");
		final AtomicReference<String> refer = new AtomicReference<String>();
		this.executor.execute(new Runnable() {
			public void run() {
				try {
					String response = TestApp1Impl.this.test2.test(kepler);
					refer.set(response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while (refer.get() == null) {

		}
		return refer.get();
	}
}
