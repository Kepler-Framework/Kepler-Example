package com.kepler.list;

import java.util.List;

public class Role {

	private List<String> nums;

	private List<City> cities;

	public List<String> getNums() {
		return this.nums;
	}

	public void setNums(List<String> nums) {
		this.nums = nums;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public String toString() {
		return "[nums=" + this.nums + "][cities=" + this.cities + "]";
	}
}
