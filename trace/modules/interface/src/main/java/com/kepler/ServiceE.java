package com.kepler;

import java.util.List;

import com.kepler.annotation.Service;

@Service(version = "0.0.1")
public interface ServiceE {

	String doE(List<Pojo> pojo) throws Exception;
	
	String doE(Complex pojo) throws Exception;
	
}
