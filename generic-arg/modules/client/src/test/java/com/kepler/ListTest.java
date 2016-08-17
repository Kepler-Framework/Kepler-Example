package com.kepler;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.wrap.GenericService;
import com.kepler.generic.wrap.arg.ListArg;
import com.kepler.generic.wrap.arg.NullArg;
import com.kepler.generic.wrap.arg.ObjectArg;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ListTest {

	@Autowired
	private GenericService generic;

	@Test
	public void test1() throws Throwable {
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test1", "kepler", new Date()));
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test1", "kepler", NullArg.NULL));
	}

	@Test
	public void test2() throws Throwable {
		ListArg roles = new ListArg().put(new ObjectArg("com.kepler.list.Role").put("nums", Arrays.asList("A", "B", "C")));
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test2", "kepler", Arrays.asList("kepler"), roles));
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test2", "kepler", Arrays.asList("kepler"), NullArg.NULL));
	}

	@Test
	public void test3() throws Throwable {
		ObjectArg city1 = new ObjectArg("com.kepler.list.City").put("id", 0L).put("name", "SH");
		ObjectArg city2 = new ObjectArg("com.kepler.list.City").put("id", 1L).put("name", "BJ");
		ListArg cities = new ListArg().put(city1).put(city2);
		ListArg roles = new ListArg().put(new ObjectArg("com.kepler.list.Role").put("nums", Arrays.asList("A", "B", "C")).put("cities", cities));
		ObjectArg members = new ObjectArg("com.kepler.list.Members").put("names", Arrays.asList("name1", "name2", "name3")).put("roles", roles);
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test3", "kepler", Arrays.asList("kepler"), members));
		System.out.println(this.generic.invoke(new Service("com.kepler.ListApp", "0.0.1-generic-arg"), "test3", "kepler", Arrays.asList("kepler"), NullArg.NULL));
	}
}
