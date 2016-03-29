package com.kepler.impl;

import java.util.List;

import com.kepler.Complex;
import com.kepler.Pojo;
import com.kepler.ServiceE;
import com.kepler.annotation.Autowired;

@Autowired
public class ServiceEImpl implements ServiceE {

	@Override
	public String doE(List<Pojo> pojo) throws Exception {
		return null;
	}

	@Override
	public String doE(Complex pojo) throws Exception {
		return null;
	}

}
