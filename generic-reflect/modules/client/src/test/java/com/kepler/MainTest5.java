package com.kepler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.reflect.GenericService;
import com.kepler.service.Service;

import junit.framework.Assert;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest5 {

	private static final String[] CLASSES_1 = new String[] { "com.kepler.domain5.User" };

	private static final String[] CLASSES_2 = new String[] {};

	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, Long> levels = new HashMap<String, Long>();
		levels.put("level-1", 1L);
		levels.put("level-2", 2L);
		levels.put("level-3", 3L);
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new int[] { 1, 2, 3 });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, Long> dept_levels_1 = new HashMap<String, Long>();
		dept_levels_1.put("level-1", 1L);
		dept_levels_1.put("level-2", 2L);
		dept_levels_1.put("level-3", 3L);
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, Long> dept_levels_2 = new HashMap<String, Long>();
		dept_levels_2.put("level-A", 1L);
		dept_levels_2.put("level-B", 2L);
		dept_levels_2.put("level-C", 3L);
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", Arrays.asList("AD1", "AD2", "AD3"));
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", Arrays.asList("A", "B", "C"));
		member_1.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, Long> member_1_levels = new HashMap<String, Long>();
		member_1_levels.put("level-1", 1L);
		member_1_levels.put("level-2", 2L);
		member_1_levels.put("level-3", 3L);
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", Arrays.asList("A", "B", "C"));
		member_2.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, Long> member_2_levels = new HashMap<String, Long>();
		member_2_levels.put("level-1", 1L);
		member_2_levels.put("level-2", 2L);
		member_2_levels.put("level-3", 3L);
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", MainTest5.CLASSES_1, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test1WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, Long> levels = new HashMap<String, Long>();
		levels.put("level-1", 1L);
		levels.put("level-2", 2L);
		levels.put("level-3", 3L);
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new int[] { 1, 2, 3 });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, Long> dept_levels_1 = new HashMap<String, Long>();
		dept_levels_1.put("level-1", 1L);
		dept_levels_1.put("level-2", 2L);
		dept_levels_1.put("level-3", 3L);
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, Long> dept_levels_2 = new HashMap<String, Long>();
		dept_levels_2.put("level-A", 1L);
		dept_levels_2.put("level-B", 2L);
		dept_levels_2.put("level-C", 3L);
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", Arrays.asList("AD1", "AD2", "AD3"));
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", Arrays.asList("A", "B", "C"));
		member_1.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, Long> member_1_levels = new HashMap<String, Long>();
		member_1_levels.put("level-1", 1L);
		member_1_levels.put("level-2", 2L);
		member_1_levels.put("level-3", 3L);
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", Arrays.asList("A", "B", "C"));
		member_2.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, Long> member_2_levels = new HashMap<String, Long>();
		member_2_levels.put("level-1", 1L);
		member_2_levels.put("level-2", 2L);
		member_2_levels.put("level-3", 3L);
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", null, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", Arrays.asList("AD1", "AD2", "AD3"));
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", Arrays.asList("A", "B", "C"));
		member_1.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", Arrays.asList("A", "B", "C"));
		member_2.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", MainTest5.CLASSES_1, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", Arrays.asList("AD1", "AD2", "AD3"));
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", Arrays.asList("A", "B", "C"));
		member_1.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", Arrays.asList("A", "B", "C"));
		member_2.put("alias", Arrays.asList("A1", "B2", "C3"));
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", null, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", new String[] { "AD1", "AD2", "AD3" });
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", new String[] { "A", "B", "C" });
		member_1.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", new String[] { "A", "B", "C" });
		member_2.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", MainTest5.CLASSES_1, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", new String[] { "AD1", "AD2", "AD3" });
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", new String[] { "A", "B", "C" });
		member_1.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", new String[] { "A", "B", "C" });
		member_2.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", null, user));
		Map<Object, Object> response_dept = Map.class.cast(response.get("dept"));
		int[] response_dept_ids = int[].class.cast(response_dept.remove("ids"));
		Assert.assertTrue(1 == response_dept_ids[0]);
		Assert.assertTrue(2 == response_dept_ids[1]);
		Assert.assertTrue(3 == response_dept_ids[2]);
		Assert.assertEquals(response.toString(), "{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=kepler, dept={levels={1={levels={level-1=1, level-2=2, level-3=3}, name=level1}, 2={levels={level-B=2, level-A=1, level-C=3}, name=level2}}, address=[AD1, AD2, AD3]}, members=[{level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_2, dept=null, members=null}, {level={levels={level-1=1, level-2=2, level-3=3}, name=level}, alias=[A1, B2, C3], roles=[{name=A}, {name=B}, {name=C}], name=member_1, dept=null, members=null}]}");
	}

	@Test
	public void test3WithNull() throws Throwable {
		Assert.assertEquals(null, this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test1", MainTest5.CLASSES_1, null));
	}

	@Test
	public void test4() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", new String[] { "AD1", "AD2", "AD3" });
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", new String[] { "A", "B", "C" });
		member_1.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", new String[] { "A", "B", "C" });
		member_2.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Object response = this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test2", MainTest5.CLASSES_1, user);
		Assert.assertEquals(null, response);
	}

	@Test
	public void test4WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> level = new HashMap<String, Object>();
		level.put("name", "level");
		Map<String, String> levels = new HashMap<String, String>();
		levels.put("level-1", "1");
		levels.put("level-2", "2");
		levels.put("level-3", "3");
		level.put("levels", levels);
		user.put("level", level);
		Map<String, Object> dept = new HashMap<String, Object>();
		dept.put("ids", new String[] { "1", "2", "3" });
		Map<Long, Object> dept_levels = new HashMap<Long, Object>();
		Map<String, Object> dept_level_1 = new HashMap<String, Object>();
		dept_level_1.put("name", "level1");
		Map<String, String> dept_levels_1 = new HashMap<String, String>();
		dept_levels_1.put("level-1", "1");
		dept_levels_1.put("level-2", "2");
		dept_levels_1.put("level-3", "3");
		dept_level_1.put("levels", dept_levels_1);
		dept_levels.put(1L, dept_level_1);
		Map<String, Object> dept_level_2 = new HashMap<String, Object>();
		dept_level_2.put("name", "level2");
		Map<String, String> dept_levels_2 = new HashMap<String, String>();
		dept_levels_2.put("level-A", "1");
		dept_levels_2.put("level-B", "2");
		dept_levels_2.put("level-C", "3");
		dept_level_2.put("levels", dept_levels_2);
		dept_levels.put(2L, dept_level_2);
		dept.put("levels", dept_levels);
		dept.put("address", new String[] { "AD1", "AD2", "AD3" });
		user.put("dept", dept);
		List<Object> members = new ArrayList<Object>();
		Map<String, Object> member_1 = new HashMap<String, Object>();
		member_1.put("name", "member_1");
		member_1.put("roles", new String[] { "A", "B", "C" });
		member_1.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_1_level = new HashMap<String, Object>();
		member_1_level.put("name", "level");
		Map<String, String> member_1_levels = new HashMap<String, String>();
		member_1_levels.put("level-1", "1");
		member_1_levels.put("level-2", "2");
		member_1_levels.put("level-3", "3");
		member_1_level.put("levels", member_1_levels);
		member_1.put("level", member_1_level);
		members.add(member_1);
		Map<String, Object> member_2 = new HashMap<String, Object>();
		member_2.put("name", "member_2");
		member_2.put("roles", new String[] { "A", "B", "C" });
		member_2.put("alias", new String[] { "A1", "B2", "C3" });
		Map<String, Object> member_2_level = new HashMap<String, Object>();
		member_2_level.put("name", "level");
		Map<String, String> member_2_levels = new HashMap<String, String>();
		member_2_levels.put("level-1", "1");
		member_2_levels.put("level-2", "2");
		member_2_levels.put("level-3", "3");
		member_2_level.put("levels", member_2_levels);
		member_2.put("level", member_2_level);
		members.add(member_2);
		user.put("members", members);
		Object response = this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test2", null, user);
		Assert.assertEquals(null, response);
	}

	@Test
	public void test5() throws Throwable {
		@SuppressWarnings("unchecked")
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test3", MainTest5.CLASSES_2));
		Assert.assertNotNull(response);
	}

	@Test
	public void test5WithNoneClass() throws Throwable {
		@SuppressWarnings("unchecked")
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp5", "0.0.1-generic"), "test3", null));
		Assert.assertNotNull(response);
	}
}
