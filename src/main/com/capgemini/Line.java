package com.capgemini;

public class Line {
	public static String WhoIsNext(String[] names, int n) {
		int a = (int) Math.round(Math.log(n / names.length + 1) / Math.log(2.0));
		int b = (int) Math.round(names.length * (-1 + Math.pow(2, a)));
		int c = (int) Math.ceil((n - b) / (Math.pow(2, a))) - 1;
		return names[c];
	}
}
