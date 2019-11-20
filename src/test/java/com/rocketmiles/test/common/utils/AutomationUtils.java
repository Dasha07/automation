package com.rocketmiles.test.common.utils;

import java.util.List;

public class AutomationUtils {

	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static String getRandomStringFromList(List<String> listOptions) {
		int index = (int) (Math.random() * listOptions.size());
		return listOptions.get(index);
	}
	public static int getRandomValue(int maxNumber) {
		int index = (int) (Math.random() * maxNumber);
		return index+1;
	}
	public static boolean compareLists(List<String> expected,List<String> actual) {
        return expected.stream().allMatch(option -> actual.contains(option));
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(AutomationUtils.getRandomValue(5));
		}
	}
}
