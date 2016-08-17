package com.kepler.map;

import java.util.Map;

public class City {

	private Map<User, Level> users;

	private Long id;

	public Map<User, Level> getUsers() {
		return users;
	}

	public void setUsers(Map<User, Level> users) {
		this.users = users;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String toString() {
		return "[id=" + this.id + "][users=" + this.users + "]";
	}
}
