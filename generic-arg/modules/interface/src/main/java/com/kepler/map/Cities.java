package com.kepler.map;

import java.util.Map;

public class Cities {

	private Map<String, City> cities;

	private Long id;

	public Map<String, City> getCities() {
		return this.cities;
	}

	public void setCities(Map<String, City> cities) {
		this.cities = cities;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return "[id=" + this.id + "][cities=" + this.cities + "]";
	}
}
