package com.kepler;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
public class MainTest1 {

	private static final String[] CLASSES_1 = new String[] { String.class.getName(), Date.class.getName(), long.class.getName(), "com.kepler.domain1.UserRole", "com.kepler.domain1.User" };

	private static final String[] CLASSES_2 = new String[] { String[].class.getName(), Date[].class.getName(), long[].class.getName(), "[Lcom.kepler.domain1.UserRole;", "[Lcom.kepler.domain1.User;" };

	private static final String[] CLASSES_3 = new String[] { String[].class.getName(), Date[].class.getName(), Long[].class.getName(), "[Lcom.kepler.domain1.UserRole;", "[Lcom.kepler.domain1.User;" };

	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new Double[] { 1d, 2d, 3d });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, "Hello world", new Date(), -1L, "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test1WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new Double[] { 1d, 2d, 3d });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, "Hello world", null, -1L, "A", user));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Assert.assertEquals(null, response.get("level"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test1WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new Double[] { 1d, 2d, 3d });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", null, "Hello world", new Date(), -1L, "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, "Hello world", new Date(), -1L, "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, null, new Date(), -1L, "A", user));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Assert.assertEquals(null, response.get("level"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", null, "Hello world", new Date(), -1L, "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, "Hello world", "2020-12-12 12:12:12", "-1", "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", MainTest1.CLASSES_1, "Hello world", "2020-12-12 12:12:12", "-1", null, user));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Assert.assertEquals(null, response.get("level"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Map<String, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test1", null, "Hello world", "2020-12-12 12:12:12", "-1", "A", user));
		Assert.assertEquals(9223372036854775807L, response.get("level"));
		Assert.assertEquals(2147483647, response.get("age"));
		Assert.assertEquals("kepler", response.get("name"));
		Object[] roles = Object[].class.cast(response.get("roles"));
		Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
		Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
		Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
		Double[] datas = Double[].class.cast(response.get("datas"));
		Assert.assertEquals(1d, datas[0]);
		Assert.assertEquals(2d, datas[1]);
		Assert.assertEquals(3d, datas[2]);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test2", MainTest1.CLASSES_2, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test2", MainTest1.CLASSES_2, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, null, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Assert.assertEquals(null, response.get("roles"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test2", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test5() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test2", MainTest1.CLASSES_2, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test5WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test2", null, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test6() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", MainTest1.CLASSES_3, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test6WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", MainTest1.CLASSES_3, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, null, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Assert.assertEquals(null, response.get("roles"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test6WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		user.put("datas", new String[] { "1", "2", "3" });
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test7() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", MainTest1.CLASSES_3, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test7WihtNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", null, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test8() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", MainTest1.CLASSES_3, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList("2012-12-12 12:12:12", "2012-12-12 12:12:12"), Arrays.asList("-1", "0"), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test8WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		Object[] responses = Object[].class.cast(this.generic.invoke(new Service("com.kepler.TestApp1", "0.0.1-generic"), "test3", null, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList("2012-12-12 12:12:12", "2012-12-12 12:12:12"), Arrays.asList("-1", "0"), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Object[] roles = Object[].class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles[0]).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles[1]).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles[2]).get("name"));
			Double[] datas = Double[].class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas[0]);
			Assert.assertEquals(2d, datas[1]);
			Assert.assertEquals(3d, datas[2]);
		}
	}
}
