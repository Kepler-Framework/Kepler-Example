package com.kepler;

import java.util.ArrayList;
import java.util.List;

import com.kepler.host.Host;
import com.kepler.protocol.Request;
import com.kepler.router.filter.HostFilter;

public class PortHostFilter implements HostFilter {

	@Override
	public List<Host> filter(Request request, List<Host> hosts) {
		List<Host> matcher = new ArrayList<Host>();
		for (Host host : hosts) {
			if (host.port() == 9876) {
				matcher.add(host);
			}
		}
		return matcher;
	}
}
