package com.kepler.domain.impl;

import java.util.List;
import java.util.Set;

import com.kepler.domain.Address;
import com.kepler.domain.Dept;
import com.kepler.domain.Level;
import com.kepler.domain.User;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class UserImpl implements User {
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private Dept dept;

	private Level level;

	private Set<Long> roles;

	private List<Address> addresses;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Set<Long> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Long> roles) {
		this.roles = roles;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
