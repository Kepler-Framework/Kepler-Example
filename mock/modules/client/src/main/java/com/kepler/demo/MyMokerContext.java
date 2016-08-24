package com.kepler.demo;

import com.kepler.mock.Mocker;
import com.kepler.mock.MockerContext;
import com.kepler.service.Service;

/**
 * 自定义MockerContext，优先级比kepler框架自带的MokerContext高
 * 
 * @author longyaokun
 * @date 2016年8月24日
 */
public class MyMokerContext implements MockerContext {
	
	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mocker get(Service service) {
		return new MyMocker();
	}

}
