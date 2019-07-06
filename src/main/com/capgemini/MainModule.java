package com.capgemini;

import java.util.HashMap;
import java.util.Map;

public class MainModule {

	public static void main(String[] args) {
		Map<String, Integer> molecules = new HashMap<>();
		molecules = ParseMolecule.getAtoms("K41[MgON(SO3)2]2");
		System.out.println(molecules);
		molecules.clear();
		molecules = ParseMolecule.getAtoms("Mg(OH)2");
		System.out.println(molecules);
		molecules.clear();
		molecules = ParseMolecule.getAtoms("MgOH)2");
		System.out.println(molecules);
	}

}
