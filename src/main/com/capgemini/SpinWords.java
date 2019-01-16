package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpinWords {

	public String spinWords(String sentence) {
		List<String> words = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
		List<String> newSentence = new ArrayList<>();
		for (String word : words) {
			if (word.length() > 4) {
				word = new StringBuilder(word).reverse().toString();
			}
			newSentence.add(word);
		}
		return String.join(" ", newSentence);
	}
}
