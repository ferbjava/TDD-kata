package com.capgemini;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SpinWordTest {
	
	@Test
	public void Test02() {
		assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
		assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
	}
	
	@Test
	public void Test01() {
		assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
	}
}
