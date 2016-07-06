package com.kepler;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kepler.transaction.Invoker;

/**
 * @author KimShen
 *
 */
public class RemoteInvoker implements Invoker {

	private static final Log LOGGER = LogFactory.getLog(RemoteInvoker.class);

	private final AtomicBoolean completed;

	private final TestApp test;

	public RemoteInvoker(TestApp test, AtomicBoolean completed) {
		super();
		this.test = test;
		this.completed = completed;
	}

	public Object invoke(String uuid, Object... args) throws Exception {
		String response = this.test.test1(uuid, uuid + " " + String.valueOf(args[0])) + this.test.test3(uuid, uuid + " " + String.valueOf(args[0]));
		RemoteInvoker.LOGGER.info("Invoke: " + response);
		synchronized (RemoteInvoker.class) {
			this.completed.set(true);
			RemoteInvoker.class.notifyAll();
		}
		return response;
	}
}
