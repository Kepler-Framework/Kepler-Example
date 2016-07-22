package com.kepler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.cache.CacheExpired;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Autowired
	private CacheExpired expired;

	@Test
	public void test1() throws Exception {
		for (int i = 0; i < 50000; i++) {
			System.out.println(this.test.test1());
		}
	}

	@Test
	public void test2() throws Exception {
		for (int i = 0; i < 50000; i++) {
			System.out.println(this.test.test2());
		}
	}

	@Test
	public void test3() throws Exception {
		int count = 0;
		for (int i = 0; i < 50000; i++) {
			System.out.println(this.test.test3());
			if (count % 10000 == 0) {
				this.expired.expired(new Service(TestApp.class), "test3");
			}
			count++;
		}
	}
}
