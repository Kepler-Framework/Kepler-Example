package com.kepler.demo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kepler-service.xml");
		context.start();
		System.in.read();
		context.close();
	}
}