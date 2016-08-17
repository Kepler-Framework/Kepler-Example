package com.kepler.domain4;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, UserRole> roles;

	private ConcurrentHashMap<Double, Long> datas;

	private String name;

	private Long level;

	private int age;

	public Map<String, UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Map<String, UserRole> roles) {
		this.roles = roles;
	}

	public ConcurrentHashMap<Double, Long> getDatas() {
		return this.datas;
	}

	public void setDatas(ConcurrentHashMap<Double, Long> datas) {
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
