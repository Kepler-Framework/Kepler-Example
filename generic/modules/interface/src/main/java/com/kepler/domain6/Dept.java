package com.kepler.domain6;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Dept extends Serializable {

	public List<Level> getLevels();

	public Map<Time, Event> getEvents();
}
