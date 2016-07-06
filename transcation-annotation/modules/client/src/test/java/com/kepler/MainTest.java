package com.kepler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	private static final Log LOGGER = LogFactory.getLog(MainTest.class);

	@Autowired
	private Trigger trigger;

	/**
	 * 当前方法重试, 直到成功
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		try {
			MainTest.LOGGER.info("Response: " + this.trigger.trigger1("Kepler"));
		} catch (Exception e) {
			MainTest.LOGGER.error(e.getMessage(), e);
		}
		synchronized (Trigger.class) {
			while (!this.trigger.completed()) {
				Trigger.class.wait();
			}
			System.out.println("free ...");
		}
	}

	/**
	 * 指定方法重试, 直到成功
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		try {
			MainTest.LOGGER.info("Response: " + this.trigger.trigger2("Kepler"));
		} catch (Exception e) {
			MainTest.LOGGER.error(e.getMessage(), e);
		}
		synchronized (Trigger.class) {
			while (!this.trigger.completed()) {
				Trigger.class.wait();
			}
			System.out.println("free ...");

		}
	}
}
