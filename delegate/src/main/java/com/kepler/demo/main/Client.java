package com.kepler.demo.main;

import junit.framework.Assert;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kepler.demo.start.QuickStart;

public class Client {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kepler-client.xml");
		QuickStart start = context.getBean(QuickStart.class);
		Assert.assertEquals("Hello Kepler", start.hi("Kepler").hello());
		context.close();
	}
}
