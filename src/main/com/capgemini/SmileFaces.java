package com.capgemini;

import java.util.List;

public class SmileFaces {

	public static int countSmileys(List<String> arr) {
		return arr.stream().map(str -> {
			if (str.matches("[:|;][-|~]?[)|D]")) {
				return 1;
			}
			return 0;
		}).mapToInt(x -> x).sum();
	}
}
