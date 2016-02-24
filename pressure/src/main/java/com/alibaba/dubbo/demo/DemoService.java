package com.alibaba.dubbo.demo;

import com.kepler.annotation.Service;

@Service(version = "0.0.1")
public interface DemoService {

	String sayHello(String name);

}