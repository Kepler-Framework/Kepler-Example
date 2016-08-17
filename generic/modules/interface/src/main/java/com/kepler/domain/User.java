package com.kepler.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface User extends Serializable {

	public Long getId();

	public Dept getDept();

	public Level getLevel();

	public Set<Long> getRoles();

	public List<Address> getAddresses();
}
