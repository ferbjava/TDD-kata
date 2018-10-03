package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class SpinWords {

	public String spinWords(String sentence) {
		List<String> words = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
		List<String> newSentence = new ArrayList<>();
		for (String word : words) {
			if (word.length() > 4) {
				char[] wordArray = word.toCharArray();
				ArrayUtils.reverse(wordArray);
				word = new String(wordArray);
			}
			newSentence.add(word);
		}
		return StringUtils.join(newSentence, " ");
	}
}
