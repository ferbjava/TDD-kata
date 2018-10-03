package com.capgemini;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {
	public static String pigIt(String str) {
		return Arrays.stream(str.split(" ")).map(w -> {
			if (w.length() > 1 || (w.chars().findFirst().getAsInt() >= 65 && w.chars().findFirst().getAsInt() <= 122)) {
				w.substring(1);
				return w.substring(1).concat(w.substring(0, 1)).concat("ay");
			}
			return w;
		}).collect(Collectors.joining(" "));
	}
}
