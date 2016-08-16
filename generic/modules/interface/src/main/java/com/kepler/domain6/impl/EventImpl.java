package com.kepler.domain6.impl;

import com.kepler.annotation.GenericElement;
import com.kepler.domain6.Event;
import com.kepler.domain6.Level;

public class EventImpl implements Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private Level level;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return this.level;
	}

	@GenericElement(LevelImpl.class)
	public void setLevel(Level level) {
		this.level = level;
	}
}
