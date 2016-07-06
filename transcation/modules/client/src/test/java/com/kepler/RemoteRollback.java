package com.kepler;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.transaction.Guid;

/**
 * @author KimShen
 *
 */
public class RemoteRollback {

	private static final Log LOGGER = LogFactory.getLog(RemoteRollback.class);

	private final AtomicBoolean completed = new AtomicBoolean();

	private final TestApp test;

	private int counter;

	public RemoteRollback(TestApp test) {
		super();
		this.test = test;
	}

	public boolean completed() {
		return this.completed.get();
	}

	public AtomicBoolean complete() {
		return this.completed;
	}

	public void rollback(String name) throws Exception {
		this.counter++;
		RemoteRollback.LOGGER.info("Rollback 1: (" + Guid.get() + ")" + this.test.test1(Guid.get(), name.substring(0, Math.min(1, (name.length() - this.counter)))));
		RemoteRollback.LOGGER.info("Rollback 2: (" + Guid.get() + ")" + this.test.test2(Guid.get(), name.substring(0, Math.min(1, (name.length() - this.counter)))));
		synchronized (RemoteInvoker.class) {
			this.completed.set(true);
			RemoteInvoker.class.notifyAll();
		}
	}
}
