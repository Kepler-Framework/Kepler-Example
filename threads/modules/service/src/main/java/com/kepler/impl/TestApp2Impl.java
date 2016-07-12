package com.kepler.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

import com.kepler.TestApp2;
import com.kepler.TestApp3;
import com.kepler.annotation.Autowired;
import com.kepler.header.HeadersContext;

@Autowired
public class TestApp2Impl implements TestApp2 {

	private final HeadersContext context;

	private final Executor executor;

	private final TestApp3 test3;

	public TestApp2Impl(HeadersContext context, Executor executor, TestApp3 test3) {
		super();
		this.test3 = test3;
		this.context = context;
		this.executor = executor;
	}

	public String test(final String kepler) throws Exception {
		this.context.get().put("test-2", "T2");
		final AtomicReference<String> refer = new AtomicReference<String>();
		this.executor.execute(new Runnable() {
			public void run() {
				try {
					String response = TestApp2Impl.this.test3.test(kepler);
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
