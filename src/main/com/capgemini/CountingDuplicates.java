package com.capgemini;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingDuplicates {
	public static int duplicateCount(String text) {
		int duplicates = 0;
		List<String> charsList = Arrays.stream(text.split("")).map(String::toUpperCase).collect(Collectors.toList());
		Set<String>charsSet = charsList.stream().collect(Collectors.toSet());
		for (String c : charsSet) {
			charsList.remove(c);
			if(charsList.contains(c)){
				duplicates++;
			}
		}
		return duplicates;
	}
}
