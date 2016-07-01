package com.kepler;

import com.kepler.transaction.Transcation;

/**
 * @author KimShen
 *
 */
public class Transcation2 implements Transcation {

	private final TestApp test;

	private int reduce = 0;

	public Transcation2(TestApp test) {
		super();
		this.test = test;
	}

	@Override
	public void transcation(String uuid, Object... args) throws Exception {
		try {
			this.test.test1(uuid, String.valueOf(args[0]));
			this.test.test3(uuid, String.valueOf(args[0]).substring(0, String.valueOf(args[0]).length() - this.reduce));
			synchronized (Transcation2.class) {
				Transcation2.class.notifyAll();
			}
		} finally {
			this.reduce++;
		}
	}
}
