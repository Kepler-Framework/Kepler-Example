package com.kepler;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.invoker.async.AsyncContext;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Test
	public void test() throws Exception {
		Future<Object> response = AsyncContext.binding(false);
		System.out.println("Response from test: " + this.test.test("http://www.ibm.com"));
		System.out.println("Wait response ...");
		System.out.println("Response from future: " + response.get());
	}
}
