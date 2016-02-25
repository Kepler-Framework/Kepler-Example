package com.kepler.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepler.TestApp;

/**
 * @author kim 2014年7月15日
 */
@Controller
public class AccessController {

	private final TestApp test;

	public AccessController(TestApp test) {
		super();
		this.test = test;
	}

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String access(String access) throws Exception {
		String response = this.test.test(access);
		return response;
	}
}
