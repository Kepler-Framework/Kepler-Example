package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.alibaba.dubbo.demo.DemoService;

public class Client {

	/**
	 * 单次循环
	 */
	private static final int CIRCLE = Integer.valueOf(System.getProperty("circle", "10000"));

	private static String build(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length * 1024; i++) {
			buffer.append("-");
		}
		return buffer.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Input the params: (server type: 1:Dubbo or 2:Kepler) (request size(KB)) (thread number) (circle times) (warming) >> ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] params = input.readLine().split(" ");
		int client = Integer.valueOf(params[0]);
		int request = Integer.valueOf(params[1]);
		int threads = Integer.valueOf(params[2]);
		int circles = Integer.valueOf(params[3]);
		Assert.isTrue(circles >= Client.CIRCLE * 2);
		Assert.isTrue(circles % Client.CIRCLE == 0);
		String buffer = Client.build(request);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(client == 1 ? "dubbo-consumer.xml" : "kepler-client.xml");
		context.start();
		// 获取远程服务代理
		DemoService demoService = (DemoService) context.getBean("demoService");
		// 预热
		for (int index = 0; index < circles / Client.CIRCLE; index++) {
			demoService.sayHello(buffer);
		}
		System.gc();
		Thread.sleep(5000);
		System.out.println("---------------------[START]---------------------");
		AtomicLong counter = new AtomicLong(circles);
		InvokerRunnable invoker = new InvokerRunnable(demoService, counter, buffer);
		ExecutorService executor = Executors.newFixedThreadPool(threads);
		// 计时
		long start = System.nanoTime();
		for (int index = 0; index < circles / Client.CIRCLE; index++) {
			executor.execute(invoker);
		}
		synchronized (counter) {
			while (counter.get() != 0) {
				counter.wait();
			}
		}
		long using = System.nanoTime() - start;
		// 完成数量 / 耗时
		long qps = (long) (circles / Double.valueOf(TimeUnit.MILLISECONDS.convert(using, TimeUnit.NANOSECONDS)) * 1000);
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
			for (int index = 0; index < Client.CIRCLE; index++) {
				this.demoService.sayHello(this.buffer);
			}
			this.counter.addAndGet(-Client.CIRCLE);
			if (this.counter.get() == 0) {
				synchronized (this.counter) {
					this.counter.notifyAll();
				}
			}
		}
	}
}