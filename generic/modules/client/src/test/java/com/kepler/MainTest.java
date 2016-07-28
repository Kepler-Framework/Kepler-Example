package com.kepler;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.generic.GenericService;
import com.kepler.generic.arg.ArrayArg;
import com.kepler.generic.arg.ListArg;
import com.kepler.generic.arg.ObjectArg;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	private static final Log LOGGER = LogFactory.getLog(MainTest.class);

	@Autowired
	private GenericService generic;

	@Test
	public void test() throws Throwable {
		// Dept
		ObjectArg dept = new ObjectArg("com.kepler.domain.impl.DeptImpl");
		dept.put("name", "lang");
		dept.put("level", new ObjectArg("com.kepler.domain.impl.LevelImpl").put("next", 0L).put("current", 1L));
		dept.put("address", new ObjectArg("com.kepler.domain.impl.AddressImpl").put("city", 0L).put("address", "SHA").put("segments", new String[] { "A1", "A2", "B1" }));
		dept.put("leaders", new ArrayArg("com.kepler.domain.impl.UserImpl").add(new ObjectArg("com.kepler.domain.impl.UserImpl").put("id", 0L)).add(new ObjectArg("com.kepler.domain.impl.UserImpl").put("id", 1L)));
		// User1 
		ObjectArg user = new ObjectArg("com.kepler.domain.impl.UserImpl");
		user.put("id", 0L);
		user.put("dept", dept);
		user.put("roles", new HashSet<Long>(Arrays.asList(1L, 2L, 3L)));
		user.put("level", new ObjectArg("com.kepler.domain.impl.LevelImpl").put("next", 0L).put("current", 1L));
		ListArg addresses = new ListArg();
		addresses.add(new ObjectArg("com.kepler.domain.impl.AddressImpl").put("city", 0L).put("address", "SH").put("segments", new String[] { "A1", "A2", "B1" }));
		addresses.add(new ObjectArg("com.kepler.domain.impl.AddressImpl").put("city", 1L).put("address", "BJ").put("segments", new String[] { "A2", "A3" }));
		user.put("addresses", addresses);
		// Signature
		ObjectArg signature = new ObjectArg("com.kepler.domain.impl.SignatureImpl").put("key", "0123456789ABCDEF").put("value", "Test Signature");
		@SuppressWarnings("unchecked")
		Map<Object, Object> apply = Map.class.cast(this.generic.invoke(new Service("com.kepler.TestApp", "0.0.1-generic"), "submit", UUID.randomUUID().toString(), new Date(), user, signature));
		MainTest.LOGGER.info(apply);
	}
}
