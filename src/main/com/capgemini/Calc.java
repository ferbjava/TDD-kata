package com.capgemini;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calc {
	public double evaluate(String expr) {
		Stack<Double> stack = new Stack<>();
		List<String> strings = Arrays.stream(expr.split(" ")).collect(Collectors.toList());
		if (strings.get(0).equals("")) {
			return 0;
		}
		for (String string : strings) {
			if (!string.equals("+") && !string.equals("-") && !string.equals("*") && !string.equals("/")) {
				stack.push(Double.parseDouble(string));
			} else if (string.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (string.equals("-")) {
				stack.push(-stack.pop() + stack.pop());
			} else if (string.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (string.equals("/")) {
				stack.push(1 / stack.pop() * stack.pop());
			}
		}
		return stack.pop();
	}
}
