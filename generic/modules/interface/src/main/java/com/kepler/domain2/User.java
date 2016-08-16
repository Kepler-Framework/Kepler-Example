package com.kepler.domain2;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserRole> roles;

	private LinkedList<Double> datas;

	private String name;

	private Long level;

	private int age;

	public List<UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public LinkedList<Double> getDatas() {
		return this.datas;
	}

	public void setDatas(LinkedList<Double> datas) {
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
