package com.kepler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.GenericService;
import com.kepler.service.Service;

import junit.framework.Assert;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest4 {

	private static final String[] CLASSES_1 = new String[] { Map.class.getName(), Map.class.getName(), Map.class.getName() };

	private static final String[] CLASSES_2 = new String[] { HashMap.class.getName(), Map.class.getName(), ConcurrentHashMap.class.getName() };

	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Date> param1 = new HashMap<String, Date>();
		param1.put("A", new Date());
		param1.put("B", new Date());
		Map<Long, String> param2 = new HashMap<Long, String>();
		param2.put(1L, "A");
		param2.put(2L, "B");
		param2.put(3L, "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		Map<Double, Long> datas = new HashMap<Double, Long>();
		datas.put(1d, 3L);
		datas.put(2d, 2L);
		datas.put(3d, 1L);
		user.put("datas", datas);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test1", MainTest4.CLASSES_1, param1, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> key_data = Map.class.cast(key.get("datas"));
		Assert.assertTrue(key_data.remove(1d) == 3L);
		Assert.assertTrue(key_data.remove(2d) == 2L);
		Assert.assertTrue(key_data.remove(3d) == 1L);
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> value_data = Map.class.cast(value.get("datas"));
		Assert.assertTrue(value_data.remove(1d) == 3L);
		Assert.assertTrue(value_data.remove(2d) == 2L);
		Assert.assertTrue(value_data.remove(3d) == 1L);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() throws Throwable {
		Map<String, String> param1 = new HashMap<String, String>();
		param1.put("A", "2012-12-12 12:12:12");
		param1.put("B", "2012-12-12 12:12:12");
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("1", "A");
		param2.put("2", "B");
		param2.put("3", "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		Map<String, String> datas = new HashMap<String, String>();
		datas.put("1", "3");
		datas.put("2", "2");
		datas.put("3", "1");
		user.put("datas", datas);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test1", MainTest4.CLASSES_1, param1, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> key_data = Map.class.cast(key.get("datas"));
		Assert.assertTrue(key_data.remove(1d) == 3L);
		Assert.assertTrue(key_data.remove(2d) == 2L);
		Assert.assertTrue(key_data.remove(3d) == 1L);
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> value_data = Map.class.cast(value.get("datas"));
		Assert.assertTrue(value_data.remove(1d) == 3L);
		Assert.assertTrue(value_data.remove(2d) == 2L);
		Assert.assertTrue(value_data.remove(3d) == 1L);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2WithNull() throws Throwable {
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("1", "A");
		param2.put("2", "B");
		param2.put("3", "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test1", MainTest4.CLASSES_1, null, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Assert.assertEquals(null, Map.class.cast(key.get("datas")));
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Assert.assertEquals(null, Map.class.cast(value.get("datas")));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() throws Throwable {
		Map<String, Date> param1 = new HashMap<String, Date>();
		param1.put("A", new Date());
		param1.put("B", new Date());
		Map<Long, String> param2 = new HashMap<Long, String>();
		param2.put(1L, "A");
		param2.put(2L, "B");
		param2.put(3L, "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		Map<Double, Long> datas = new HashMap<Double, Long>();
		datas.put(1d, 3L);
		datas.put(2d, 2L);
		datas.put(3d, 1L);
		user.put("datas", datas);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test2", MainTest4.CLASSES_2, param1, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> key_data = Map.class.cast(key.get("datas"));
		Assert.assertTrue(key_data.remove(1d) == 3L);
		Assert.assertTrue(key_data.remove(2d) == 2L);
		Assert.assertTrue(key_data.remove(3d) == 1L);
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> value_data = Map.class.cast(value.get("datas"));
		Assert.assertTrue(value_data.remove(1d) == 3L);
		Assert.assertTrue(value_data.remove(2d) == 2L);
		Assert.assertTrue(value_data.remove(3d) == 1L);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4() throws Throwable {
		Map<String, String> param1 = new HashMap<String, String>();
		param1.put("A", "2012-12-12 12:12:12");
		param1.put("B", "2012-12-12 12:12:12");
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("1", "A");
		param2.put("2", "B");
		param2.put("3", "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		Map<String, String> datas = new HashMap<String, String>();
		datas.put("1", "3");
		datas.put("2", "2");
		datas.put("3", "1");
		user.put("datas", datas);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test2", MainTest4.CLASSES_2, param1, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> key_data = Map.class.cast(key.get("datas"));
		Assert.assertTrue(key_data.remove(1d) == 3L);
		Assert.assertTrue(key_data.remove(2d) == 2L);
		Assert.assertTrue(key_data.remove(3d) == 1L);
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Map<Double, Long> value_data = Map.class.cast(value.get("datas"));
		Assert.assertTrue(value_data.remove(1d) == 3L);
		Assert.assertTrue(value_data.remove(2d) == 2L);
		Assert.assertTrue(value_data.remove(3d) == 1L);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4WithNull() throws Throwable {
		Map<String, String> param2 = new HashMap<String, String>();
		param2.put("1", "A");
		param2.put("2", "B");
		param2.put("3", "C");
		Map<Map<String, Object>, Map<String, Object>> param3 = new HashMap<Map<String, Object>, Map<String, Object>>();
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("age", "1");
		user.put("level", "10");
		user.put("name", "user");
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("roles-1", "A");
		roles.put("roles-2", "B");
		roles.put("roles-3", "C");
		user.put("roles", roles);
		param3.put(user, user);
		Map<Object, Object> response = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp4", "0.0.1-generic"), "test2", MainTest4.CLASSES_2, null, param2, param3));
		Map<String, Object> key = Map.class.cast(response.keySet().iterator().next());
		Assert.assertEquals(1, key.get("age"));
		Assert.assertEquals(10L, key.get("level"));
		Assert.assertEquals("user", key.get("name"));
		Map<String, String> key_user = Map.class.cast(key.get("roles"));
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(key_user.remove("roles-3")).get("name"), "C");
		Assert.assertEquals(null, Map.class.cast(key.get("datas")));
		Map<String, Object> value = Map.class.cast(response.values().iterator().next());
		Assert.assertEquals(1, value.get("age"));
		Assert.assertEquals(10L, value.get("level"));
		Assert.assertEquals("user", value.get("name"));
		Map<String, String> value_user = Map.class.cast(value.get("roles"));
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-1")).get("name"), "A");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-2")).get("name"), "B");
		Assert.assertEquals(Map.class.cast(value_user.remove("roles-3")).get("name"), "C");
		Assert.assertEquals(null, Map.class.cast(value.get("datas")));
	}
}