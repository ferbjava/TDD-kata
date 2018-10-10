package com.capgemini;

public class Line {
	public static String WhoIsNext(String[] names, int n) {
//		if (names.length == 1) {
//			return names[0];
//		} else {
//			double x = Math.log(n / names.length + 1) / Math.log(2.0);
//			int a = (int) Math.round(Math.log(n / names.length + 1) / Math.log(2.0));
//			int b = (int) Math.round(names.length * (Math.pow(2, a) - 1));
//			int c = (int) Math.ceil((n - b) / (Math.pow(2, a))) - 1;
//			return names[c];
//		}
		int r = n;
		int l = names.length;
		while (r >= l) { r -= l; l *= 2; }
		return names[(int) Math.ceil(names.length * r / l)-1];
	}
}
