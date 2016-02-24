package com.kepler.impl;

import com.kepler.Printer;
import com.kepler.annotation.Autowired;
import com.kepler.trace.TraceEnabled;
import com.kepler.trace.TraceLogger;

@Autowired
@TraceLogger(logger = "com.kepler.impl.TestApplImpl")
public class PrinterImpl implements Printer {

	public String print(String kepler) throws Exception {
		return "Hello " + kepler;
	}

	@TraceEnabled(when="args[1] == 0")
	@Override
	public String print(String word, int printerType) throws Exception {
		return "[PrinterType: " + printerType + "] Hello " + word;
	}

}
