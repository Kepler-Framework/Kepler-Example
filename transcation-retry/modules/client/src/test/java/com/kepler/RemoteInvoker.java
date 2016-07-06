package com.kepler;

import java.util.concurrent.atomic.AtomicBoolean;

import com.kepler.transaction.Guid;
import com.kepler.transaction.Invoker;

/**
 * @author KimShen
 *
 */
public class RemoteInvoker implements Invoker {

	private final AtomicBoolean completed = new AtomicBoolean();

	private final TestApp test;

	private int reduce = 0;

	public RemoteInvoker(TestApp test) {
		super();
		this.test = test;
	}

	public boolean completed() {
		return this.completed.get();
	}

	@Override
	public Object invoke(String uuid, Object... args) throws Exception {
		try {
			this.test.test1(Guid.get(), String.valueOf(args[0]).substring(0, String.valueOf(args[0]).length() - this.reduce));
			this.test.test2(Guid.get(), String.valueOf(args[0]).substring(0, String.valueOf(args[0]).length() - this.reduce));
			synchronized (RemoteInvoker.class) {
				this.completed.set(true);
				RemoteInvoker.class.notifyAll();
			}
			return "OK";
		} finally {
			this.reduce++;
		}
	}
}
