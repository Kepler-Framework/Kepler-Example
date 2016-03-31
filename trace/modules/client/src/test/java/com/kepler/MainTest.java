package com.kepler;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private ServiceE service;

	@Autowired
	private ServiceA nestedService;

	Random random = new Random();

	@Test
	public void test_ser() throws Exception {
		Pojo pojo = new Pojo();
		pojo.setAge(24);
		pojo.setName("zhangjiehao");
		service.doE(Arrays.asList(pojo));

		Complex complex = new Complex();
		complex.setPojos(Arrays.asList(pojo));

		System.in.read();
	}

	@Test
	public void test_tracePath() throws Exception {
		for (int i = 0; i < 100; i++) {
			nestedService.doA();
		}
	}

}
