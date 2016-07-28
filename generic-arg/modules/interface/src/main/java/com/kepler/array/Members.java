package com.kepler.array;

import java.util.Arrays;

/**
 * @author KimShen
 *
 */
public class Members {

	private String[] names;

	private Role[] roles;

	public String[] getNames() {
		return this.names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public Role[] getRoles() {
		return this.roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	public String toString() {
		return "[names=" + (this.names != null ? Arrays.toString(this.names) : "") + "][roles=" + (this.roles != null ? Arrays.toString(this.roles) : "") + "]";
	}
}
