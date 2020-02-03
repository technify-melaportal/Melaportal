package com.beerrun.common;

import java.math.BigDecimal;

public class TestUtils {

	
	public static void main(String ...strings) {
		String t1= "11:12:07";
		String t2= "11:12:03";
		
		BigDecimal bigDecimal = new BigDecimal(t2).subtract(new BigDecimal(t1));
		System.out.println(bigDecimal);
	}
		
}
