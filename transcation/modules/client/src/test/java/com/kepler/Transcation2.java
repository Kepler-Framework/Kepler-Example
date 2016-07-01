package com.kepler;

import com.kepler.transaction.Transcation;

/**
 * @author KimShen
 *
 */
public class Transcation2 implements Transcation {

	private final TestApp test;

	public Transcation2(TestApp test) {
		super();
		this.test = test;
	}

	@Override
	public void transcation(String uuid, Object... args) throws Exception {
		this.test.test1(uuid, String.valueOf(args[0]));
		this.test.test3(uuid, String.valueOf(args[0]));
		synchronized (Transcation2.class) {
			Transcation2.class.notifyAll();
		}
	}
}
