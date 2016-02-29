package com.kepler;

import java.util.Arrays;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.invoker.async.AsyncCallback;
import com.kepler.invoker.async.AsyncContext;
import com.kepler.invoker.async.AsyncPromise;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp1 test1;

	@Autowired
	private TestApp2 test2;

	@Autowired
	private AsyncPromise promise;

	@Test
	public void test() throws Exception {
		Future<Object> response1 = AsyncContext.binding(false);
		this.test1.test("http://www.163.com");
		Future<Object> response2 = AsyncContext.binding(false);
		this.test2.test("http://www.126.com");
		this.promise.promise(new AsyncCallback() {
			protected void callback(Object... args) {
				System.out.println(Arrays.toString(args));
				synchronized (MainTest.this) {
					MainTest.this.notifyAll();
				}
			}

			protected void throwable(Throwable throwable) {
				throwable.printStackTrace();
				synchronized (MainTest.this) {
					MainTest.this.notifyAll();
				}
			}
		}, response1, response2);
		synchronized (this) {
			this.wait();
		}
	}
}
