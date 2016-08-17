package com.kepler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

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
public class MainTest2 {

	private static final String[] CLASSES_1 = new String[] { List.class.getName(), List.class.getName(), List.class.getName(), List.class.getName(), List.class.getName() };

	private static final String[] CLASSES_2 = new String[] { ArrayList.class.getName(), CopyOnWriteArrayList.class.getName(), List.class.getName(), List.class.getName(), LinkedList.class.getName() };

	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", MainTest2.CLASSES_1, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test1WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", null, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", MainTest2.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", MainTest2.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new Long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new Long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", MainTest2.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("roles", new String[] { "A", "B", "C" });
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", MainTest2.CLASSES_1, null, Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			Assert.assertEquals(null, response.get("datas"));
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1.0, datas.get(0));
			Assert.assertEquals(2.0, datas.get(1));
			Assert.assertEquals(3.0, datas.get(2));
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test5() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test2", MainTest2.CLASSES_2, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas.get(0));
			Assert.assertEquals(2d, datas.get(1));
			Assert.assertEquals(3d, datas.get(2));
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void test5WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", Arrays.asList("A", "B", "C"));
		user.put("datas", Arrays.asList("1", "2", "3"));
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test2", null, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), Arrays.asList("A", "B", "C"), Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas.get(0));
			Assert.assertEquals(2d, datas.get(1));
			Assert.assertEquals(3d, datas.get(2));
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test2", MainTest2.CLASSES_2, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas.get(0));
			Assert.assertEquals(2d, datas.get(1));
			Assert.assertEquals(3d, datas.get(2));
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
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test2", null, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			List<Object> roles = List.class.cast(response.get("roles"));
			Assert.assertEquals("A", Map.class.cast(roles.get(0)).get("name"));
			Assert.assertEquals("B", Map.class.cast(roles.get(1)).get("name"));
			Assert.assertEquals("C", Map.class.cast(roles.get(2)).get("name"));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas.get(0));
			Assert.assertEquals(2d, datas.get(1));
			Assert.assertEquals(3d, datas.get(2));
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test6WithNull() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", String.valueOf(Long.MAX_VALUE));
		user.put("age", String.valueOf(Integer.MAX_VALUE));
		user.put("datas", Arrays.asList("1", "2", "3"));
		List<Object> responses = List.class.cast(this.generic.invoke(new Service("com.kepler.TestApp2", "0.0.1-generic"), "test2", MainTest2.CLASSES_2, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), null, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Assert.assertEquals(null, List.class.cast(response.get("roles")));
			List<Object> datas = List.class.cast(response.get("datas"));
			Assert.assertEquals(1d, datas.get(0));
			Assert.assertEquals(2d, datas.get(1));
			Assert.assertEquals(3d, datas.get(2));
		}
	}
}
