package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseMolecule {

	private static List<String> atoms = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg",
			"Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
			"Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd",
			"In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ti",
			"Pb", "Bi", "Po", "At", "Rn");

	private static Map<String, Integer> mol = new HashMap<String, Integer>();

	public static Map<String, Integer> getAtoms(String formula) {

		List<String> str = Arrays.stream(formula.split("")).collect(Collectors.toList());

		List<String> molecules = new ArrayList<>();
		List<String> moleculesInBrackets = new ArrayList<>();
		List<Integer> occurence = new ArrayList<>();
		List<Integer> leftBrackets = new ArrayList<>();
		List<Integer> rightBrackets = new ArrayList<>();
		Map<String, Integer> mol = new HashMap<>();

		// mol.put("O", 3);
		// mol.put("N", 2);
		// mol.compute("Ca", (k, v) -> v == null ? 1 : v + 1);
		// mol.compute("N", (k, v) -> v == null ? 1 : v + 1);
		// System.out.println(mol.toString());

		List<List<String>> globalList = new ArrayList<>();
		List<String> localList = new ArrayList<>();

		String molecule = "";
		String recentMolecule = "";
		Integer occur = 0;
		for (int i = 0; i < str.size(); i++) {
			String recentChar = str.get(i);

			if (Character.isUpperCase(recentChar.toCharArray()[0])) {
				verifyMolecule(recentMolecule);
				localList.add(recentMolecule);
				recentMolecule = recentChar;
			} else if (Character.isLowerCase(recentChar.toCharArray()[0])) {
				recentMolecule = recentMolecule.concat(recentChar);
				verifyMolecule(recentMolecule);
				localList.add(recentMolecule);

			} else if (Character.isDigit(recentChar.toCharArray()[0])) {
				globalList.add(localList);
				localList.clear();
				recentMolecule = "";
				occur = occur * 10 + Integer.parseInt(recentChar);
			} else if (recentChar.matches("(|[")) {

			} else if (recentChar.matches(")|]")) {
				globalList.add(localList);
				localList.clear();
			} else {
				throw new IllegalArgumentException();
			}

		}
		
		ParseMolecule.addMolecule("C");
		ParseMolecule.addMolecule("C");
		ParseMolecule.addMolecule("Na");

		return ParseMolecule.mol;
//		return new HashMap<String, Integer>();
	}

	private static void addMolecule(String molecule) {
		ParseMolecule.mol.compute(molecule, (k, v) -> v == null ? 1 : v + 1);
	}

	private static void verifyMolecule(String molecule) {
		if (!molecule.equals("") && !ParseMolecule.atoms.contains(molecule)) {
			throw new IllegalArgumentException();
		}
	}
}
