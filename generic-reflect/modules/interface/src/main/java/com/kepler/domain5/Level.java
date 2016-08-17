package com.kepler.domain5;

import java.io.Serializable;
import java.util.Map;

/**
 * @author KimShen
 *
 */
public class Level implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Map<String, Long> levels;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Long> getLevels() {
		return this.levels;
	}

	public void setLevels(Map<String, Long> levels) {
		this.levels = levels;
	}
}
