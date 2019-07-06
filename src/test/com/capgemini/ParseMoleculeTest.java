package com.capgemini;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ParseMoleculeTest {

	@Test
	public void testMolecule1() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("As", 2);
		testMap.put("B", 8);
		testMap.put("Cu", 5);
		testMap.put("Be", 16);
		testMap.put("C", 44);
		testMap.put("Co", 24);
		testMap.put("O", 48);

		assertEquals(testMap, ParseMolecule.getAtoms("As2{Be4C5[BCo3(CO2)3]2}4Cu5"));
	}

	@Test
	public void testMolecule2() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("S", 3);
		testMap.put("H", 42);
		testMap.put("Co", 4);
		testMap.put("N", 12);
		testMap.put("O", 18);

		assertEquals(testMap, ParseMolecule.getAtoms("{[Co(NH3)4(OH)2]3Co}(SO4)3"));
	}

	@Test
	public void testMolecule3() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("Mg", 1);
		testMap.put("H", 2);
		testMap.put("O", 2);

		assertEquals(testMap, ParseMolecule.getAtoms("Mg(OH)2"));
	}

	@Test
	public void testMolecule4() {
		Map<String, Integer> testMap = new HashMap<>();
		testMap.put("K", 41);
		testMap.put("Mg", 2);
		testMap.put("O", 14);
		testMap.put("N", 2);
		testMap.put("S", 4);

		assertEquals(testMap, ParseMolecule.getAtoms("K41[MgON(SO3)2]2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMolecule5() {
		ParseMolecule.getAtoms("Au5(C2H5[OH)3Li]3");
		fail();
	}
	
}
