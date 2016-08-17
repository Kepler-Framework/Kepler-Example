package com.kepler.domain;

import java.io.Serializable;

/**
 * @author KimShen
 *
 */
public interface Signature extends Serializable {

	public String getKey();

	public String getValue();
}
