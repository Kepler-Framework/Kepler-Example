package main.kepler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kepler-service.xml");
		context.start();
		// 按任意键退出
		System.in.read();
		context.close();
	}
}
