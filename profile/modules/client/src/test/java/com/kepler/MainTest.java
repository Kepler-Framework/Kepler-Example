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
	private TestApp1 test1;

	@Autowired
	private TestApp2 test2;

	@Test
	public void test1() throws Exception {
		System.out.println(this.test1.test("kepler"));
	}

	@Test
	public void test2() throws Exception {
		System.out.println(this.test2.test("kepler"));
	}
}
