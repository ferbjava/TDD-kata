package com.capgemini;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

class Solution {

	static String toCamelCase(String s) {
		List<String> words = Arrays.stream(s.split("-|_")).collect(Collectors.toList());
		for (int i = 1; i < words.size(); i++) {
			words.set(i, StringUtils.capitalize(words.get(i)));
		}
		return StringUtils.join(words, "");
	}
}