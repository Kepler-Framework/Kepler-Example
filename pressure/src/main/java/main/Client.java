package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class Client {

	private static String build(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length * 1024; i++) {
			buffer.append("-");
		}
		return buffer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Input the params: (server type: 1:Dubbo or 2:Kepler) (request size(KB)) (thread number) (circle times) >> ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] params = input.readLine().split(" ");
		int client = Integer.valueOf(params[0]);
		int request = Integer.valueOf(params[1]);
		int threads = Integer.valueOf(params[2]);
		int circles = Integer.valueOf(params[3]);
		String buffer = Client.build(request);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(client == 1 ? "dubbo-consumer.xml" : "kepler-client.xml");
		context.start();
		// 获取远程服务代理
		DemoService demoService = (DemoService) context.getBean("demoService");
		// 预热
		for (int index = 0; index < circles; index++) {
			demoService.sayHello(buffer);
		}
		AtomicLong counter = new AtomicLong(circles);
		InvokerRunnable invoker = new InvokerRunnable(demoService, counter, buffer);
		ExecutorService executor = Executors.newFixedThreadPool(threads);
		// 计时
		long start = System.nanoTime();
		for (int index = 0; index < circles; index++) {
			executor.execute(invoker);
		}
		synchronized (counter) {
			while (counter.get() != 0) {
				counter.wait();
			}
		}
		long using = System.nanoTime() - start;
		// 完成数量 / 耗时
		long qps = (circles / TimeUnit.SECONDS.convert(using, TimeUnit.NANOSECONDS));
		// 耗时 / 完成数量
		double per = (Double.valueOf(using) / circles) / 1000 / 1000;
		System.out.println("Using: " + using);
		System.out.println("Qps: " + qps);
		System.out.println("Per: " + per);
		context.close();
	}

	private static class InvokerRunnable implements Runnable {

		private final DemoService demoService;

		private final AtomicLong counter;

		private final String buffer;

		public InvokerRunnable(DemoService demoService, AtomicLong counter, String buffer) {
			super();
			this.demoService = demoService;
			this.counter = counter;
			this.buffer = buffer;
		}

		public void run() {
			this.demoService.sayHello(this.buffer);
			this.counter.decrementAndGet();
			if (this.counter.get() == 0) {
				synchronized (this.counter) {
					this.counter.notifyAll();
				}
			}
		}
	}
}