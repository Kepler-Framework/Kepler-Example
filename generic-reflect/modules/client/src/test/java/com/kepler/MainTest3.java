package com.kepler;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

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
public class MainTest3 {

	private static final String[] CLASSES_1 = new String[] { Set.class.getName(), Set.class.getName(), Set.class.getName(), Set.class.getName(), Set.class.getName() };

	private static final String[] CLASSES_2 = new String[] { TreeSet.class.getName(), CopyOnWriteArraySet.class.getName(), Set.class.getName(), Set.class.getName(), HashSet.class.getName() };

	@Autowired
	private GenericService generic;

	@Test
	@SuppressWarnings("unchecked")
	public void test1() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new HashSet<String>(Arrays.asList("A", "B", "C")));
		user.put("datas", new HashSet<String>(Arrays.asList("1", "2", "3")));
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", MainTest3.CLASSES_1, Arrays.asList("Hello world1", "Hello world2"), new HashSet<Date>(Arrays.asList(new Date(), new Date())), new HashSet<Long>(Arrays.asList(-1L, 0L)), new HashSet<String>(Arrays.asList("A", "B", "C")), new HashSet<Map<String, Object>>(Arrays.asList(user, user))));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test1WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new HashSet<String>(Arrays.asList("A", "B", "C")));
		user.put("datas", new HashSet<String>(Arrays.asList("1", "2", "3")));
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", null, Arrays.asList("Hello world1", "Hello world2"), new HashSet<Date>(Arrays.asList(new Date(), new Date())), new HashSet<Long>(Arrays.asList(-1L, 0L)), new HashSet<String>(Arrays.asList("A", "B", "C")), new HashSet<Map<String, Object>>(Arrays.asList(user, user))));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", MainTest3.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", MainTest3.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new Long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new Date[] { new Date(), new Date() }, new Long[] { -1L, 0L }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", MainTest3.CLASSES_1, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", null, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, new Object[] { user, user }));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test1", MainTest3.CLASSES_1, null, new HashSet<Date>(Arrays.asList(new Date(), new Date())), new HashSet<Long>(Arrays.asList(-1L, 0L)), new HashSet<String>(Arrays.asList("A", "B", "C")), new HashSet<Map<String, Object>>(Arrays.asList(user, user))));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Assert.assertEquals(null, response.get("datas"));
		}
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test5() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new HashSet<String>(Arrays.asList("A", "B", "C")));
		user.put("datas", new HashSet<String>(Arrays.asList("1", "2", "3")));
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test2", MainTest3.CLASSES_2, new HashSet<String>(Arrays.asList("Hello world1", "Hello world2")), new HashSet<Date>(Arrays.asList(new Date(), new Date())), new HashSet<Long>(Arrays.asList(-1L, 0L)), new HashSet<String>(Arrays.asList("A", "B", "C")), new HashSet<Map>(Arrays.asList(user, user))));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
		}
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test5WithNoneClass() throws Throwable {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", "kepler");
		user.put("level", Long.MAX_VALUE);
		user.put("age", Integer.MAX_VALUE);
		user.put("roles", new HashSet<String>(Arrays.asList("A", "B", "C")));
		user.put("datas", new HashSet<String>(Arrays.asList("1", "2", "3")));
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test2", null, new HashSet<String>(Arrays.asList("Hello world1", "Hello world2")), new HashSet<Date>(Arrays.asList(new Date(), new Date())), new HashSet<Long>(Arrays.asList(-1L, 0L)), new HashSet<String>(Arrays.asList("A", "B", "C")), new HashSet<Map>(Arrays.asList(user, user))));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test2", MainTest3.CLASSES_2, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test2", null, new String[] { "Hello world1", "Hello world2" }, new String[] { "2012-12-12 12:12:12", "2012-12-12 12:12:12" }, new String[] { "-1", "0" }, new String[] { "A", "B", "C" }, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Set<Object> roles = Set.class.cast(response.get("roles"));
			Assert.assertEquals("[{name=C}, {name=B}, {name=A}]", roles.toString());
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
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
		Set<Object> responses = Set.class.cast(this.generic.invoke(new Service("com.kepler.TestApp3", "0.0.1-generic"), "test2", MainTest3.CLASSES_2, Arrays.asList("Hello world1", "Hello world2"), Arrays.asList(new Date(), new Date()), Arrays.asList(-1L, 0L), null, Arrays.asList(user, user)));
		for (Object each : responses) {
			Map<String, Object> response = Map.class.cast(each);
			Assert.assertEquals(9223372036854775807L, response.get("level"));
			Assert.assertEquals(2147483647, response.get("age"));
			Assert.assertEquals("kepler", response.get("name"));
			Assert.assertEquals(null, Set.class.cast(response.get("roles")));
			Set<Object> datas = Set.class.cast(response.get("datas"));
			Assert.assertEquals("[1.0, 2.0, 3.0]", datas.toString());
		}
	}
}
