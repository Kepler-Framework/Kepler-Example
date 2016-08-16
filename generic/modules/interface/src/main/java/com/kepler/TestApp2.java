package com.kepler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kepler.annotation.Service;
import com.kepler.domain2.User;
import com.kepler.domain2.UserRole;

@Service(version = "0.0.1-generic")
public interface TestApp2 {

	public Collection<User> test1(List<String> param1, List<Date> param2, List<Long> param3, List<UserRole> param4, List<User> param5) throws Exception;

	public Collection<User> test2(ArrayList<String> param1, CopyOnWriteArrayList<Date> param2, List<Long> param3, List<UserRole> param4, LinkedList<User> param5) throws Exception;
}
