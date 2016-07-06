package com.kepler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.transaction.Transaction;
import com.kepler.transaction.impl.DefaultRequest;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	private final static Log LOGGER = LogFactory.getLog(MainTest.class);

	@Autowired
	private Transaction transaction;

	@Autowired
	private RemoteInvoker invoker;

	@Test
	public void test() throws Exception {
		try {
			String request = "1234567890";
			MainTest.LOGGER.info("Response: " + this.transaction.commit(new DefaultRequest(RemoteInvoker.class, "invoke", request), this.invoker));
		} catch (Exception e) {
			e.printStackTrace();
		}
		synchronized (RemoteInvoker.class) {
			while (!this.invoker.completed()) {
				RemoteInvoker.class.wait();
			}
			System.out.println("free ... ");
		}
	}
}
