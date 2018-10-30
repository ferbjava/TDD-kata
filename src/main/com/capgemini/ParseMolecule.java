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

		System.out.println("molecule: " + formula.toString());
		List<String> str = Arrays.stream(formula.split("")).collect(Collectors.toList());

		// List<Integer> leftBrackets = new ArrayList<>();
		// List<Integer> rightBrackets = new ArrayList<>();

		List<Integer> localOccurence = new ArrayList<>();
		List<String> localMolecules = new ArrayList<>();

		List<Integer> globalOccurence = new ArrayList<>();
		List<String> globalMolecules = new ArrayList<>();

		String recentMolecule = "";
		Integer recentOccurence = 0;
		for (int i = 0; i < str.size(); i++) {
			String recentChar = str.get(i);

			if (Character.isUpperCase(recentChar.toCharArray()[0])) {
				verifyMolecule(recentMolecule);
				if (!recentMolecule.equals("")){
					localMolecules.add(recentMolecule);
					if (recentOccurence == 0) {
						localOccurence.add(1);
					} else {
						localOccurence.add(recentOccurence);
					}
				}

				recentOccurence = 0;
				recentMolecule = recentChar;

			} else if (Character.isLowerCase(recentChar.toCharArray()[0])) {
				recentMolecule = recentMolecule.concat(recentChar);

			} else if (Character.isDigit(recentChar.toCharArray()[0])) {
				recentOccurence = recentOccurence * 10 + Integer.parseInt(recentChar);

			} else if (recentChar.equals("[") || recentChar.equals("(")) {
				verifyMolecule(recentMolecule);
				if (!recentMolecule.equals("")){
					localMolecules.add(recentMolecule);
					if (recentOccurence == 0) {
						localOccurence.add(1);
					} else {
						localOccurence.add(recentOccurence);
					}
				}
				recentMolecule = "";
				recentOccurence = 0;
				globalMolecules.addAll(localMolecules);
				globalOccurence.addAll(localOccurence);
				localMolecules.clear();
				localOccurence.clear();
				
			} else if (recentChar.equals("]") || recentChar.equals(")")) {
				

			} else {
				throw new IllegalArgumentException();
			}
		}

		localMolecules.add(recentMolecule);
		if (recentOccurence == 0) {
			localOccurence.add(1);
		} else {
			localOccurence.add(recentOccurence);
		}

		globalMolecules.addAll(localMolecules);
		globalOccurence.addAll(localOccurence);

		for (int i = 0; i < globalMolecules.size(); i++) {
			addMolecule(globalMolecules.get(i), globalOccurence.get(i));
		}

		return ParseMolecule.mol;
	}

	private static void addMolecule(String molecule, Integer occurence) {
		ParseMolecule.mol.compute(molecule, (k, v) -> v == null ? occurence : v + occurence);
	}

	private static void verifyMolecule(String molecule) {
		if (!molecule.equals("") && !ParseMolecule.atoms.contains(molecule)) {
			throw new IllegalArgumentException();
		}
	}
}
