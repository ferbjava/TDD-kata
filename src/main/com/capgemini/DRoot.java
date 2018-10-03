package com.capgemini;

public class DRoot {

	public static int digital_root(int n) {
		int number = n;
		while (Integer.toString(number).length() != 1) {
			number = Integer.toString(number).chars().map(a -> a - '0').sum();
		}
		return number;
	}
}
