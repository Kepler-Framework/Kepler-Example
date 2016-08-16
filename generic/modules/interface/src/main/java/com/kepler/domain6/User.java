package com.kepler.domain6;

import java.io.Serializable;

import com.kepler.annotation.GenericElement;
import com.kepler.domain6.impl.DeptImpl;

public interface User extends Serializable {

	public Dept getDept();
	
	@GenericElement(DeptImpl.class)
	public void setDept(Dept dept);
}
