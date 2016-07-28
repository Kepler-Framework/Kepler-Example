package com.kepler.array;

import java.util.Arrays;

public class Role {

	private String[] nums;

	private City[] cities;

	public String[] getNums() {
		return this.nums;
	}

	public void setNums(String[] nums) {
		this.nums = nums;
	}

	public City[] getCities() {
		return this.cities;
	}

	public void setCities(City[] cities) {
		this.cities = cities;
	}

	public String toString() {
		return "[nums=" + (this.nums != null ? Arrays.toString(this.nums) : "") + "][cities=" + (this.cities != null ? Arrays.toString(this.cities) : "") + "]";
	}
}
