package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.DemoService;
import com.kepler.annotation.Autowired;

@Autowired
public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return name;
	}
}