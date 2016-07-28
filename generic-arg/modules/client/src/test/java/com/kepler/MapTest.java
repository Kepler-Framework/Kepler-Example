package com.kepler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.GenericService;
import com.kepler.generic.arg.MapArg;
import com.kepler.generic.arg.NullArg;
import com.kepler.generic.arg.ObjectArg;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MapTest {

	@Autowired
	private GenericService generic;

	@Test
	public void test1() throws Throwable {
		Map<String, Date> dates = new HashMap<String, Date>();
		dates.put("A-1", new Date());
		dates.put("A-2", new Date());
		MapArg users = new MapArg();
		users.put("U-1", new ObjectArg("com.kepler.map.User").put("name", "U1"));
		users.put("U-2", new ObjectArg("com.kepler.map.User").put("name", "U2"));
		System.out.println(this.generic.invoke(new Service("com.kepler.MapApp", "0.0.1-generic-arg"), "test1", dates, users));
		System.out.println(this.generic.invoke(new Service("com.kepler.MapApp", "0.0.1-generic-arg"), "test1", dates, NullArg.NULL));
	}

	@Test
	public void test2() throws Throwable {
		// Arg1
		MapArg users = new MapArg();
		users.put(new ObjectArg("com.kepler.map.User").put("name", "U1"), new ObjectArg("com.kepler.map.Level").put("name", "L1"));
		users.put(new ObjectArg("com.kepler.map.User").put("name", "U2"), new ObjectArg("com.kepler.map.Level").put("name", "L2"));
		// Arg2
		ObjectArg cities = new ObjectArg("com.kepler.map.Cities");
		cities.put("id", 0L);
		ObjectArg city = new ObjectArg("com.kepler.map.City");
		city.put("id", 1L);
		MapArg levels = new MapArg();
		levels.put(new ObjectArg("com.kepler.map.User").put("name", "U1-1"), new ObjectArg("com.kepler.map.Level").put("name", "L1-1"));
		levels.put(new ObjectArg("com.kepler.map.User").put("name", "U2-1"), new ObjectArg("com.kepler.map.Level").put("name", "L1-2"));
		city.put("users", levels);
		MapArg cities_map = new MapArg();
		cities_map.put("SHA", city);
		cities.put("cities", cities_map);
		System.out.println(this.generic.invoke(new Service("com.kepler.MapApp", "0.0.1-generic-arg"), "test2", users, cities));
		System.out.println(this.generic.invoke(new Service("com.kepler.MapApp", "0.0.1-generic-arg"), "test2", users, NullArg.NULL));
	}

}
