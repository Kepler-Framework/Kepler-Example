package com.kepler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.header.HeadersContext;
import com.kepler.host.Host;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Autowired
	private HeadersContext context;

	@Test
	public void test1() throws Exception {
		System.out.println(this.test.test("kepler"));
	}

	@Test
	public void test2() throws Exception {
		this.context.get().put(Host.TAG_KEY, "kepler");
		System.out.println(this.test.test("kepler"));
	}
}
