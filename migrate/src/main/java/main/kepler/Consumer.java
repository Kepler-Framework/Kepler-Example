package main.kepler;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kepler-client.xml");
		context.start();
		// 获取远程服务代理
		DemoService demoService = (DemoService) context.getBean("demoService");
		// 预热
		Consumer.invoke(demoService);
		// 执行远程方法
		long start = System.currentTimeMillis();
		Consumer.invoke(demoService);
		long using = System.currentTimeMillis() - start;
		System.out.println("Using " + using + "ms");
		context.close();
	}

	private static void invoke(DemoService demoService) {
		for (int index = 0; index < 100000; index++) {
			demoService.sayHello("world");
		}
	}

}