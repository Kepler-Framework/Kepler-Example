package com.kepler.domain.impl;

import com.kepler.domain.Address;
import com.kepler.domain.Dept;
import com.kepler.domain.Level;
import com.kepler.domain.User;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class DeptImpl implements Dept {
	
	private static final long serialVersionUID = 1L;

	private String name;

	private Level level;

	private User[] leaders;

	private Address address;

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

	public User[] getLeaders() {
		return this.leaders;
	}

	public void setLeaders(User[] leaders) {
		this.leaders = leaders;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
