package com.kepler.domain.impl;

import com.kepler.domain.Signature;
import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author KimShen
 *
 */
public class SignatureImpl implements Signature {
	
	private static final long serialVersionUID = 1L;

	private String key;

	private String value;

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
