package com.capgemini;

import static org.junit.Assert.*;
import org.junit.Test;

public class HighAndLowTest {
	
	@Test
	public void Test() {
		assertEquals("42 -9", HighAndLow.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
	}
}
