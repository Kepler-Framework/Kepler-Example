package com.kepler;

import com.kepler.transaction.Transcation;

/**
 * @author KimShen
 *
 */
public class Transcation1 implements Transcation {

	private final TestApp test;

	public Transcation1(TestApp test) {
		super();
		this.test = test;
	}

	@Override
	public void transcation(String uuid, Object... args) throws Exception {
		this.test.test1(uuid, String.valueOf(args[0]));
		this.test.test2(uuid, String.valueOf(args[0]));
	}
}
