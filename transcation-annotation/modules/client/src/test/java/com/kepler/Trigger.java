package com.kepler;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.annotation.Rollback;

/**
 * @author KimShen
 *
 */
public class Trigger {

	private static final Log LOGGER = LogFactory.getLog(Trigger.class);

	private final AtomicBoolean completed = new AtomicBoolean();

	private final AtomicInteger counter = new AtomicInteger();

	private TestApp test;

	public Trigger() {
		super();
	}

	public Trigger(TestApp test) {
		super();
		this.test = test;
	}

	public boolean completed() {
		return this.completed.get();
	}

	@Rollback(clazz = Trigger.class, method = "trigger1")
	public String trigger1(String name) throws Exception {
		String test = this.test.test(name);
		Trigger.LOGGER.info("SUCCESS: " + test);
		synchronized (Trigger.class) {
			this.completed.set(true);
			Trigger.class.notifyAll();
		}
		return test;
	}

	@Rollback(clazz = Trigger.class, method = "rollback")
	public String trigger2(String name) throws Exception {
		String test = this.test.test(name);
		Trigger.LOGGER.info("SUCCESS: " + test);
		synchronized (Trigger.class) {
			this.completed.set(true);
			Trigger.class.notifyAll();
		}
		return test;
	}

	public void rollback(String name) {
		if (this.counter.incrementAndGet() < 10) {
			throw new RuntimeException();
		}
		Trigger.LOGGER.info("ROLLBACK: " + test);
		synchronized (Trigger.class) {
			this.completed.set(true);
			Trigger.class.notifyAll();
		}
	}
}
