package com.kepler.domain.impl;

import com.kepler.domain.Address;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class AddressImpl implements Address {

	private static final long serialVersionUID = 1L;

	private long city;

	private String address;

	private String[] segments;

	public long getCity() {
		return this.city;
	}

	public void setCity(long city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getSegments() {
		return this.segments;
	}

	public void setSegments(String[] segments) {
		this.segments = segments;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
