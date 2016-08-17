package com.kepler.domain6.impl;

import java.util.List;
import java.util.Map;

import com.kepler.annotation.GenericElement;
import com.kepler.domain6.Dept;
import com.kepler.domain6.Event;
import com.kepler.domain6.Level;
import com.kepler.domain6.Time;

public class DeptImpl implements Dept {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Level> levels;

	private Map<Time, Event> events;

	@GenericElement(LevelImpl.class)
	public List<Level> getLevels() {
		return this.levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	@GenericElement({ TimeImpl.class, EventImpl.class })
	public Map<Time, Event> getEvents() {
		return this.events;
	}

	public void setEvents(Map<Time, Event> events) {
		this.events = events;
	}
}
