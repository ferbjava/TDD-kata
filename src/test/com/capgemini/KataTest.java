package com.capgemini;
import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.StringCalculator;

public class KataTest {

	@Test
	public void shouldReturn1() {
		// given
		Integer EXPECTED_RESULT = 1;
		String argument = "1";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}

	@Test
	public void shouldReturn3v01() {
		// given
		Integer EXPECTED_RESULT = 3;
		String argument = "1,2";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}

	@Test
	public void shouldReturn3v02() {
		// given
		Integer EXPECTED_RESULT = 3;
		String argument = "1\n2";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}

	@Test
	public void shouldReturn6() {
		// given
		Integer EXPECTED_RESULT = 6;
		String argument = "1\n2,3";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}

	@Test
	public void shouldReturn6WithFirstLine() {
		// given
		Integer EXPECTED_RESULT = 6;
		String argument = "//;\n1;2;3";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}

	@Test
	public void shouldReturn6WithLongDelimiter() {
		// given
		Integer EXPECTED_RESULT = 6;
		String argument = "//***\n1***2***3";
		StringCalculator calc = new StringCalculator();
		
		// when
		Integer result = calc.add(argument);
		
		// then
		assertEquals(EXPECTED_RESULT, result);
	}
}
