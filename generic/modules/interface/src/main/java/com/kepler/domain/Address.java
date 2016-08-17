package com.kepler.domain;

import java.io.Serializable;

/**
 * @author KimShen
 *
 */
public interface Address extends Serializable{

	public long getCity();

	public String getAddress();

	public String[] getSegments();
}
