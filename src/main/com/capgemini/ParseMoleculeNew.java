package com.capgemini;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ParseMoleculeNew {
	
	private static List<String> atoms = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg",
			"Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
			"Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd",
			"In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ti",
			"Pb", "Bi", "Po", "At", "Rn");
	
	public static Map<String, Integer> getAtoms(String formula) {
		String[] separate = formula.split("(?![a-z])");
		return null;
	}
	
	private static void verifyMolecule(String molecule) {
		if(!molecule.equals("") && !atoms.contains(molecule)) {
			throw new IllegalArgumentException();
		}
	}

}
