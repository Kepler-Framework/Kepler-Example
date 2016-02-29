package com.kepler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Test
	public void test() throws Exception {
		ExecutorService services = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			services.execute(new TestRunable());
		}
		services.shutdown();
		while (!services.awaitTermination(1000, TimeUnit.MILLISECONDS)) {

		}
	}

	private class TestRunable implements Runnable {
		public void run() {
			try {
				System.out.println(MainTest.this.test.test("kepler"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
