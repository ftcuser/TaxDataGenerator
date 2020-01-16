package com.citizant.irs.taxdatagenerator.generator;

import java.util.Random;

public class GeneratorUtils {
	public static final String PADDING="00000000000000000000000000000";
	
	/**
	 * Generate random number for array index
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getRandomInt(int start, int end) {
		int randomInt = start + (int)((end - start) * Math.random());
		return randomInt;
	}
	
	/**
	 * Generate random number for array index
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getRandomLong(long start, long end) {
		long randomlong = start + (long)((end - start) * Math.random());
		return randomlong;
	}
	/*
	 * Generate random SSN that not duplicate with existing ones.
	 */
	public static String getSSN() {
		int part1 = getRandomInt(100, 999);
		int part2 = getRandomInt(0, 99);
		int part3 = getRandomInt(0, 9999);		
		String ssn = paddingNumber(part1, 3) + "-" + paddingNumber(part2, 2) + "-" + paddingNumber(part3, 4);
		return ssn;
	}
	
	/*
	 * Padding number to required length by add 0s 
	 */
	public static String paddingNumber(int number, int length) {
		String s = "" + number;
		if(s.length() < length) {
			s = PADDING.substring(0, length - s.length()) + s;
		}
		return s;
	}
	
	/*
	 * This is random simulation that try to check if a special condition 
	 * should be triggered by check if the random number is between a
	 * given percentage of 0 to percent.
	 */
	public static boolean isTrue(double percentage) {
		double d = Math.random();
		percentage = percentage / 100.0;
		if(d <= percentage) {
			return true;
		}
		return false;
	}
	
	/*
	 * This function generate a random number 
	 * with Gaussian distribution
	 */
	public static long normalRandom(long mean) {
		// create random object 
        Random ran = new Random(); 
        // generating integer 
        double nxt = ran.nextGaussian();       
        long wage = mean + (long)(mean * nxt);
        if(wage < 0 ) wage = 0;
        return wage;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getSSN());
	}
}
