package com.kepler.list;

import java.util.List;

/**
 * @author KimShen
 *
 */
public class Members {

	private List<String> names;

	private List<Role> roles;

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String toString() {
		return "[names=" + this.names + "][roles=" + this.roles + "]";
	}
}
