package com.kepler.domain6.impl;

import com.kepler.annotation.GenericElement;
import com.kepler.domain6.Dept;
import com.kepler.domain6.User;

public class UserImpl implements User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dept dept;

	@GenericElement({ DeptImpl.class })
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
