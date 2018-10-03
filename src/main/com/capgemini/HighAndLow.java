package com.capgemini;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighAndLow {
	public static String highAndLow(String numbers) {
		
		List<Integer> numberList = Arrays
									.stream(numbers.split(" "))
									.map(Integer::parseInt)
									.collect(Collectors.toList());
		
		return "" + Collections.max(numberList) + " " + Collections.min(numberList);
	}
}