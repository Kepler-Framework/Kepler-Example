package com.kepler.domain6;

import java.io.Serializable;

public interface Event extends Serializable {

	public String getName();

	public Level getLevel();
}
