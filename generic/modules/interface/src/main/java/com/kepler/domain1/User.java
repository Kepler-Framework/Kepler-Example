package com.kepler.domain1;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserRole[] roles;

	private Double[] datas;

	private String name;

	private Long level;

	private int age;

	public UserRole[] getRoles() {
		return this.roles;
	}

	public void setRoles(UserRole[] roles) {
		this.roles = roles;
	}

	public Double[] getDatas() {
		return this.datas;
	}

	public void setDatas(Double[] datas) {
		this.datas = datas;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevel() {
		return this.level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
