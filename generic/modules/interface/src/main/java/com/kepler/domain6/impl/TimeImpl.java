package com.kepler.domain6.impl;

import java.util.Date;

import com.kepler.domain6.Time;

public class TimeImpl implements Time {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date time;

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
