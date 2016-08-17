package com.kepler.domain;

import java.io.Serializable;

/**
 * @author KimShen
 *
 */
public interface Level extends Serializable {

	public long getNext();

	public long getCurrent();
}
