package com.kepler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp1 test4remote;
	
	@Autowired
	private TestApp1 test4local;

	@Test
	public void test() throws Exception {
		System.out.println(this.test4remote.test("kepler"));
		System.out.println(this.test4local.test("kepler"));
	}
}
