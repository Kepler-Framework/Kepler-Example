package com.kepler.domain3;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<UserRole> roles;

	private TreeSet<Double> datas;

	private String name;

	private Long level;

	private int age;

	public Set<UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public TreeSet<Double> getDatas() {
		return this.datas;
	}

	public void setDatas(TreeSet<Double> datas) {
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
