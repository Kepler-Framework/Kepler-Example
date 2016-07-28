package com.kepler.domain;

import java.io.Serializable;

/**
 * @author KimShen
 *
 */
public interface Dept extends Serializable {

	public String getName();

	public Level getLevel();

	public User[] getLeaders();

	public Address getAddress();
}
