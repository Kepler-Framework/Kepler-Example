package com.kepler;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

import com.kepler.annotation.Service;
import com.kepler.domain3.User;
import com.kepler.domain3.UserRole;

@Service(version = "0.0.1-generic")
public interface TestApp3 {

	public Collection<User> test1(Set<String> param1, Set<Date> param2, Set<Long> param3, Set<UserRole> param4, Set<User> param5) throws Exception;

	public Collection<User> test2(TreeSet<String> param1, CopyOnWriteArraySet<Date> param2, Set<Long> param3, Set<UserRole> param4, HashSet<User> param5) throws Exception;
}
