package com.capgemini;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortOdd {

	public static int[] sortArray(int[] array) {
//		int[] a = Arrays.stream(array).filter(number -> number % 2 != 0).sorted().toArray();
//
//		Arrays.stream(array).map(number -> {
//			if (number % 2 != 0) {
//				return 0;
//			} else {
//				return 0;
//			}
//		}).toArray();

		List<Integer> oddNumbers = new ArrayList<>();
		List<Integer> oddIndexes = new ArrayList<>();
		int[] sortedArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				oddNumbers.add(array[i]);
				oddIndexes.add(i);
			} else {
				sortedArray[i] = array[i];
			}
		}

		Collections.sort(oddNumbers);
		for (int i = 0; i < oddIndexes.size(); i++) {
			sortedArray[oddIndexes.get(i)] = oddNumbers.get(i);
		}

		return sortedArray;
	}

}
