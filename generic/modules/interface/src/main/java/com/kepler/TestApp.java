package com.kepler;
import java.util.Date;

import com.kepler.annotation.Service;
import com.kepler.domain.Apply;
import com.kepler.domain.Signature;
import com.kepler.domain.User;

@Service(version = "0.0.1-generic")
public interface TestApp {

	public Apply submit(String uid, Date time, User user, Signature signature) throws Exception;
}
