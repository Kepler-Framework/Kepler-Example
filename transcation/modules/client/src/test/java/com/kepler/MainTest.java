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

	private static final Log LOGGER = LogFactory.getLog(MainTest.class);

	@Autowired
	private RemoteRollback rollback;

	@Autowired
	private Transaction transaction;

	@Autowired
	private TestApp test;

	@Test
	public void test() throws Exception {
		try {
			String request = "1234567890";
			MainTest.LOGGER.info("Response: " + this.transaction.commit(new DefaultRequest(RemoteRollback.class, "rollback", request), new RemoteInvoker(this.test, this.rollback.complete())));
		} catch (Exception e) {
			MainTest.LOGGER.error(e.getMessage(), e);
		}
		synchronized (RemoteInvoker.class) {
			while (!this.rollback.completed()) {
				RemoteInvoker.class.wait();
			}
			System.out.println("free ... ");
		}
	}
}
