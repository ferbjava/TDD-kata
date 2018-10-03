package com.capgemini;

import java.util.ArrayList;
import java.util.List;

public class Multi35 {
	public int solution(int number) {
		List<Integer> dividers = new ArrayList<>();
		for (int i = 1; i <number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				dividers.add(i);
			}
		}
		return dividers.stream().mapToInt(i -> i).sum();
	}
}
