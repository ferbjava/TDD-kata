package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
	private List<String> delimiters = new ArrayList<>(Arrays.asList(",", "\n", ";"));
	private List<Integer> numbers = new ArrayList<>();
	private final Integer DELIMITER_DEFINITION_LENGTH = 3;

	public StringCalculator() {
	}

	public Integer add(String inputString) {
		String reducedString = inputString;
		String delimiter = chooseDelimiter(inputString);
		
		if (!delimiter.equals("")) {
			delimiters.clear();
			delimiters.add(delimiter);
			reducedString = reducedString.substring(DELIMITER_DEFINITION_LENGTH + delimiter.length());
		}
		
		DelimiterTO delimiterTO = findFirstDelimiter(reducedString, delimiters);

		while (delimiterTO.getStartIndex() != -1) {
			numbers.add(Integer.parseInt(reducedString.substring(0, delimiterTO.getStartIndex())));
			reducedString = reducedString.substring(delimiterTO.getStartIndex() + delimiterTO.getDelimiter().length());
			delimiterTO = findFirstDelimiter(reducedString, delimiters);
		}

		numbers.add(Integer.parseInt(reducedString));
		return numbers.stream().mapToInt(a -> a).sum();
	}
	
	// private methods

	private String chooseDelimiter(String string) {
		String startString = "//";
		if (string.startsWith(startString)) {
			int delimiterEndLocation = string.indexOf("\n");
			String delimiter = string.substring(startString.length(), delimiterEndLocation);
			return delimiter;
		}
		return "";
	}

	private DelimiterTO findFirstDelimiter(String string, List<String> values) {
		DelimiterTO delimiterTO = new DelimiterTO();
		delimiterTO.setStartIndex(string.length());
		boolean anyExist = false;
		
		for (String value : values) {
			Integer tempIndex = string.indexOf(value);
			if (tempIndex != -1 && tempIndex < delimiterTO.getStartIndex()) {
				anyExist = true;
				delimiterTO.setStartIndex(tempIndex);
				delimiterTO.setDelimiter(value);
			}
		}
		if (!anyExist) {
			delimiterTO.setStartIndex(-1);
		}
		return delimiterTO;
	}
}
