package com.kepler;
import com.kepler.annotation.Service;

@Service(version = "0.0.1-printerTrace")
public interface Printer {

	public static final int WOOD_PRINTER = 0;
	
	public static final int METAL_PRINTER = 1;
	
	public String print(String word, int printerType) throws Exception;
}
