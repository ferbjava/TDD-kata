package com.capgemini;

//import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ParseMoleculeTest2 {

	@Test
	public void testMolecule() {
		System.out.println("My test");
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("C", 2);
		testMap.put("Na", 1);

		assertEquals(testMap, ParseMolecule.getAtoms("]"));
	}
	
	
}
