package com.kepler.domain5;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;

	private int[] ids;

	private List<String> address;

	private Map<Long, Level> levels;

	public int[] getIds() {
		return this.ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public Map<Long, Level> getLevels() {
		return this.levels;
	}

	public void setLevels(Map<Long, Level> levels) {
		this.levels = levels;
	}
}
