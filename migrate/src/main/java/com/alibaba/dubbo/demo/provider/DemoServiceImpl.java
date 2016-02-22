package com.alibaba.dubbo.demo.provider;

import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.dubbo.demo.DemoService;
import com.kepler.annotation.Autowired;

@Autowired
public class DemoServiceImpl implements DemoService {

	private final AtomicInteger index = new AtomicInteger();

	private final String[] buffers;

	public DemoServiceImpl() {
		this.buffers = new String[] { this.build(128), this.build(512), this.build(1024) };
	}

	private String build(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append("-");
		}
		return buffer.toString();
	}

	public String sayHello(String name) {
		return this.buffers[this.index.incrementAndGet() % 3] + " " + name;
	}
}