package com.kepler;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.reflect.GenericService;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest6 {

	private static final String[] CLASSES_1 = new String[] { "com.kepler.domain6.impl.UserImpl" };

	private static final String[] CLASSES_2 = new String[] { "com.kepler.domain6.User" };
	
	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		Map<String, Object> dept = new HashMap<String, Object>();
		user.put("dept", dept);
		Map<String, Object> level_1 = new HashMap<String, Object>();
		level_1.put("ids", new int[] { 1, 2, 3 });
		Map<String, Object> level_2 = new HashMap<String, Object>();
		level_2.put("ids", new int[] { 1, 2, 3 });
		dept.put("levels", Arrays.asList(level_1, level_2));
		Map<Object, Object> events = new HashMap<Object, Object>();
		dept.put("events", events);
		Map<String, Object> time_1 = new HashMap<String, Object>();
		time_1.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_1 = new HashMap<String, Object>();
		event_1.put("name", "event-1");
		Map<String, Object> event_1_level = new HashMap<String, Object>();
		event_1_level.put("ids", new int[] { 1, 2, 3 });
		event_1.put("level", event_1_level);
		events.put(time_1, event_1);
		Map<String, Object> time_2 = new HashMap<String, Object>();
		time_2.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_2 = new HashMap<String, Object>();
		event_2.put("name", "event-2");
		Map<String, Object> event_2_level = new HashMap<String, Object>();
		event_2_level.put("ids", new int[] { 1, 2, 3 });
		event_2.put("level", event_2_level);
		events.put(time_2, event_2);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp6", "0.0.1-generic"), "test1", MainTest6.CLASSES_1, user));
		for (Object each : Collection.class.cast(Map.class.cast(response.get("dept")).get("levels"))) {
			Map<Object, Object> level = Map.class.cast(each);
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		for (Object each : Map.class.cast(Map.class.cast(response.get("dept")).get("events")).values()) {
			Map<Object, Object> level = Map.class.cast(Map.class.cast(each).get("level"));
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		Assert.assertEquals("{dept={levels=[{}, {}], events={{time=Wed Dec 12 00:12:12 CST 2012}={level={}, name=event-2}}}}", response.toString());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		Map<String, Object> dept = new HashMap<String, Object>();
		user.put("dept", dept);
		Map<String, Object> level_1 = new HashMap<String, Object>();
		level_1.put("ids", new String[] { "1", "2", "3" });
		Map<String, Object> level_2 = new HashMap<String, Object>();
		level_2.put("ids", new String[] { "1", "2", "3" });
		dept.put("levels", Arrays.asList(level_1, level_2));
		Map<Object, Object> events = new HashMap<Object, Object>();
		dept.put("events", events);
		Map<String, Object> time_1 = new HashMap<String, Object>();
		time_1.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_1 = new HashMap<String, Object>();
		event_1.put("name", "event-1");
		Map<String, Object> event_1_level = new HashMap<String, Object>();
		event_1_level.put("ids", new String[] { "1", "2", "3" });
		event_1.put("level", event_1_level);
		events.put(time_1, event_1);
		Map<String, Object> time_2 = new HashMap<String, Object>();
		time_2.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_2 = new HashMap<String, Object>();
		event_2.put("name", "event-2");
		Map<String, Object> event_2_level = new HashMap<String, Object>();
		event_2_level.put("ids", new String[] { "1", "2", "3" });
		event_2.put("level", event_2_level);
		events.put(time_2, event_2);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp6", "0.0.1-generic"), "test1", MainTest6.CLASSES_1, user));
		for (Object each : Collection.class.cast(Map.class.cast(response.get("dept")).get("levels"))) {
			Map<Object, Object> level = Map.class.cast(each);
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		for (Object each : Map.class.cast(Map.class.cast(response.get("dept")).get("events")).values()) {
			Map<Object, Object> level = Map.class.cast(Map.class.cast(each).get("level"));
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		Assert.assertEquals("{dept={levels=[{}, {}], events={{time=Wed Dec 12 00:12:12 CST 2012}={level={}, name=event-2}}}}", response.toString());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test3() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		Map<String, Object> dept = new HashMap<String, Object>();
		user.put("dept", dept);
		Map<String, Object> level_1 = new HashMap<String, Object>();
		level_1.put("ids", new int[] { 1, 2, 3 });
		Map<String, Object> level_2 = new HashMap<String, Object>();
		level_2.put("ids", new int[] { 1, 2, 3 });
		dept.put("levels", Arrays.asList(level_1, level_2));
		Map<Object, Object> events = new HashMap<Object, Object>();
		dept.put("events", events);
		Map<String, Object> time_1 = new HashMap<String, Object>();
		time_1.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_1 = new HashMap<String, Object>();
		event_1.put("name", "event-1");
		Map<String, Object> event_1_level = new HashMap<String, Object>();
		event_1_level.put("ids", new int[] { 1, 2, 3 });
		event_1.put("level", event_1_level);
		events.put(time_1, event_1);
		Map<String, Object> time_2 = new HashMap<String, Object>();
		time_2.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_2 = new HashMap<String, Object>();
		event_2.put("name", "event-2");
		Map<String, Object> event_2_level = new HashMap<String, Object>();
		event_2_level.put("ids", new int[] { 1, 2, 3 });
		event_2.put("level", event_2_level);
		events.put(time_2, event_2);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp6", "0.0.1-generic"), "test2", MainTest6.CLASSES_2, user));
		for (Object each : Collection.class.cast(Map.class.cast(response.get("dept")).get("levels"))) {
			Map<Object, Object> level = Map.class.cast(each);
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		for (Object each : Map.class.cast(Map.class.cast(response.get("dept")).get("events")).values()) {
			Map<Object, Object> level = Map.class.cast(Map.class.cast(each).get("level"));
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		Assert.assertEquals("{dept={levels=[{}, {}], events={{time=Wed Dec 12 00:12:12 CST 2012}={level={}, name=event-2}}}}", response.toString());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test4() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		Map<String, Object> dept = new HashMap<String, Object>();
		user.put("dept", dept);
		Map<String, Object> level_1 = new HashMap<String, Object>();
		level_1.put("ids", new String[] { "1", "2", "3" });
		Map<String, Object> level_2 = new HashMap<String, Object>();
		level_2.put("ids", new String[] { "1", "2", "3" });
		dept.put("levels", Arrays.asList(level_1, level_2));
		Map<Object, Object> events = new HashMap<Object, Object>();
		dept.put("events", events);
		Map<String, Object> time_1 = new HashMap<String, Object>();
		time_1.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_1 = new HashMap<String, Object>();
		event_1.put("name", "event-1");
		Map<String, Object> event_1_level = new HashMap<String, Object>();
		event_1_level.put("ids", new String[] { "1", "2", "3" });
		event_1.put("level", event_1_level);
		events.put(time_1, event_1);
		Map<String, Object> time_2 = new HashMap<String, Object>();
		time_2.put("time", "2012-12-12 12:12:12");
		Map<String, Object> event_2 = new HashMap<String, Object>();
		event_2.put("name", "event-2");
		Map<String, Object> event_2_level = new HashMap<String, Object>();
		event_2_level.put("ids", new String[] { "1", "2", "3" });
		event_2.put("level", event_2_level);
		events.put(time_2, event_2);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp6", "0.0.1-generic"), "test2", MainTest6.CLASSES_2, user));
		for (Object each : Collection.class.cast(Map.class.cast(response.get("dept")).get("levels"))) {
			Map<Object, Object> level = Map.class.cast(each);
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		for (Object each : Map.class.cast(Map.class.cast(response.get("dept")).get("events")).values()) {
			Map<Object, Object> level = Map.class.cast(Map.class.cast(each).get("level"));
			int[] ids = int[].class.cast(level.remove("ids"));
			Assert.assertTrue(ids[0] == 1);
			Assert.assertTrue(ids[1] == 2);
			Assert.assertTrue(ids[2] == 3);
		}
		Assert.assertEquals("{dept={levels=[{}, {}], events={{time=Wed Dec 12 00:12:12 CST 2012}={level={}, name=event-2}}}}", response.toString());
	}
}
