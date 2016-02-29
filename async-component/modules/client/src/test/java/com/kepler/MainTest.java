package com.kepler;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.invoker.async.AsyncComponent;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Test
	public void test() throws Exception {
		AsyncComponent component = new AsyncComponent() {
			protected void call() throws Throwable {
				MainTest.this.test.test("http://www.ibm.com");
			}
		};
		Future<Object> future = component.future();
		System.out.println("Wait response ...");
		System.out.println("Response from future: " + future.get());
	}
}
