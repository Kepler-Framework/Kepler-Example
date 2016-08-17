package com.kepler;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.wrap.GenericService;
import com.kepler.generic.wrap.arg.ArrayArg;
import com.kepler.generic.wrap.arg.NullArg;
import com.kepler.generic.wrap.arg.ObjectArg;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ArrayTest {

	@Autowired
	private GenericService generic;

	@Test
	public void test1() throws Throwable {
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test1", "kepler", new Date()));
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test1", "kepler", NullArg.NULL));
	}

	@Test
	public void test2() throws Throwable {
		ArrayArg roles = new ArrayArg("com.kepler.array.Role").put(new ObjectArg("com.kepler.array.Role").put("nums", new String[] { "A", "B", "C" }));
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test2", "kepler", new String[] { "kepler" }, roles));
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test2", "kepler", new String[] { "kepler" }, NullArg.NULL));
	}

	@Test
	public void test3() throws Throwable {
		ObjectArg city1 = new ObjectArg("com.kepler.array.City").put("id", 0L).put("name", "SH");
		ObjectArg city2 = new ObjectArg("com.kepler.array.City").put("id", 1L).put("name", "BJ");
		ArrayArg cities = new ArrayArg("com.kepler.array.City").put(city1).put(city2);
		ArrayArg roles = new ArrayArg("com.kepler.array.Role").put(new ObjectArg("com.kepler.array.Role").put("nums", new String[] { "A", "B", "C" }).put("cities", cities));
		ObjectArg members = new ObjectArg("com.kepler.array.Members").put("names", new String[] { "name1", "name2", "name3" }).put("roles", roles);
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test3", "kepler", new String[] { "kepler" }, members));
		System.out.println(this.generic.invoke(new Service("com.kepler.ArrayApp", "0.0.1-generic-arg"), "test3", "kepler", new String[] { "kepler" }, NullArg.NULL));
	}
}
