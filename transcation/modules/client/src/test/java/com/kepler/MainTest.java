package com.kepler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.transaction.TranscationContext;
import com.kepler.transaction.impl.DefaultRequest;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TranscationContext context;

	@Test
	public void test() throws Exception {
		this.context.commit(new DefaultRequest(Transcation1.class, Transcation2.class, "1234567890"));
		synchronized (Transcation2.class) {
			Transcation2.class.wait();
			System.out.println("free ... ");
		}
	}
}
