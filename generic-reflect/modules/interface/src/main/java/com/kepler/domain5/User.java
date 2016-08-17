package com.kepler.domain5;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserRole> roles;

	private List<String> alias;

	private Set<User> members;

	private Dept dept;

	private String name;

	private Level level;

	public List<UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public List<String> getAlias() {
		return this.alias;
	}

	public void setAlias(List<String> alias) {
		this.alias = alias;
	}

	public Set<User> getMembers() {
		return this.members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
