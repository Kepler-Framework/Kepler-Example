package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
	public static void main(String[] args) throws Exception {
		System.out.println("Input server type: 1:(Dubbo) or 2:(Kepler) >>");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(input.readLine().equals("1") ? "classpath:dubbo-provider.xml" : "kepler-service.xml");
		context.start();
		// 按任意键退出
		System.in.read();
		context.close();
	}
}
