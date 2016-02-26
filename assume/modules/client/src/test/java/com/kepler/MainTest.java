package com.kepler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kepler.host.Host;
import com.kepler.host.HostState;
import com.kepler.host.HostsContext;
import com.kepler.router.filter.impl.AssumedSelector;
import com.kepler.service.Service;

@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	@Autowired
	private TestApp test;

	@Autowired
	private HostsContext context;

	@Autowired
	private AssumedSelector selector;

	private void print(Service service, Collection<Host> hosts) {
		for (Host host : this.context.getOrCreate(service).select(HostState.ACTIVE)) {
			System.out.println("Host: " + host.address());
		}
		System.out.println(">> Input your address: ");
	}

	@Test
	public void test() throws Exception {
		Service service = new Service(TestApp.class);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int index = 0; index < 10; index++) {
			Collection<Host> hosts = this.context.getOrCreate(service).select(HostState.ACTIVE);
			this.print(service, hosts);
			this.selector.set(service, reader.readLine());
			System.out.println(this.test.test("kepler"));
		}
	}
}
