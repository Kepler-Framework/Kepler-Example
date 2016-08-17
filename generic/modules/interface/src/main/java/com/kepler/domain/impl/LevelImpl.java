package com.kepler.domain.impl;

import com.kepler.domain.Level;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class LevelImpl implements Level {
	
	private static final long serialVersionUID = 1L;

	private long next;

	private long current;

	public long getNext() {
		return this.next;
	}

	public void setNext(long next) {
		this.next = next;
	}

	public long getCurrent() {
		return this.current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
