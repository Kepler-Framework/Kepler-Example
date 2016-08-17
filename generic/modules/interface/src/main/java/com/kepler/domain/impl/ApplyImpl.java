package com.kepler.domain.impl;

import java.io.Serializable;

import com.kepler.domain.Apply;
import com.kepler.domain.User;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class ApplyImpl implements Apply,Serializable {

	private static final long serialVersionUID = 1L;

	private final Long id;

	private final User user;

	public ApplyImpl(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}

	public Long getId() {
		return this.id;
	}

	public User getUser() {
		return this.user;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
