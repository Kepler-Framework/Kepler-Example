package com.kepler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.impl.ChainedTestApp;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private ChainedTestApp test;

	@Test
	public void test() throws Exception {
		// 循环以请求所有可能的主机
		for (int index = 0; index < 10; index++) {
			System.out.println(this.test.test("kepler"));
		}
	}
}
