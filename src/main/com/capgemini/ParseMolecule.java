package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParseMolecule {

	private static List<String> atoms = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg",
			"Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
			"Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd",
			"In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ti",
			"Pb", "Bi", "Po", "At", "Rn");

	private static Map<String, Integer> mol = new HashMap<String, Integer>();

	private static List<String> moleculesInLocalBrackets = new ArrayList<>();
	private static List<Integer> occurenceInLocalBrackets = new ArrayList<>();
	
	private static Stack<List<String>> moleculesGlobalStack = new Stack<>();
	private static Stack<List<Integer>> occurenceGlobalStack = new Stack<>();

	public static Map<String, Integer> getAtoms(String formula) {

		List<String> chars = Arrays.asList(formula.split(""));

//		List<String> moleculesGlobal = new ArrayList<>();
//		List<Integer> occurenceGlobal = new ArrayList<>();

		String recentMolecule = "";
		Integer recentOccurence = 0;

		Boolean wasPreviousBracket = false;

		for (int i = 0; i < chars.size(); i++) {
			String recentChar = chars.get(i);

			if (Character.isUpperCase(recentChar.toCharArray()[0])) {
				verifyMolecule(recentMolecule);
				addMoleculeToLocalBrackets(recentMolecule, recentOccurence);
				recentMolecule = recentChar;
				recentOccurence = 1;
				
				wasPreviousBracket = false;

			} else if (Character.isLowerCase(recentChar.toCharArray()[0])) {
				recentMolecule = recentMolecule.concat(recentChar);
				verifyMolecule(recentMolecule);
				addMoleculeToLocalBrackets(recentMolecule, recentOccurence);
				recentMolecule = "";
				recentOccurence = 0;
				
				wasPreviousBracket = false;

			} else if (Character.isDigit(recentChar.toCharArray()[0])) {
				if (!recentMolecule.equals("")) {
					verifyMolecule(recentMolecule);
					addMoleculeToLocalBrackets(recentMolecule, recentOccurence);
				}
				recentOccurence = recentOccurence * 10 + Integer.parseInt(recentChar);
				
				wasPreviousBracket = false;
				
			} else if (recentChar.matches("\\(|\\[")) {
				verifyMolecule(recentMolecule);
				addMoleculeToLocalBrackets(recentMolecule, recentOccurence);
				

			} else if (recentChar.matches("\\)|\\]")) {
				if (wasPreviousBracket) {
					
				}
				
				wasPreviousBracket = true;

			} else {
				throw new IllegalArgumentException();
			}
		}

		////////////////////////////////////////////////////////////////////////////////
		// System.out.println("molecule: " + formula.toString());
		// List<String> str =
		//////////////////////////////////////////////////////////////////////////////// Arrays.stream(formula.split("")).collect(Collectors.toList());
		//
		// List<Integer> localOccurence = new ArrayList<>();
		// List<String> localMolecules = new ArrayList<>();
		//
		// List<Integer> globalOccurence = new ArrayList<>();
		// List<String> globalMolecules = new ArrayList<>();
		//
		// List<Integer> occcurenceInBrackets = new ArrayList<>();
		// List<String> moleculesInBrackets = new ArrayList<>();
		//
		//
		// String recentMolecule = "";
		// Integer recentOccurence = 0;
		// for (int i = 0; i < str.size(); i++) {
		// String recentChar = str.get(i);
		//
		// if (Character.isUpperCase(recentChar.toCharArray()[0])) {
		// verifyMolecule(recentMolecule);
		// if (!recentMolecule.equals("")){
		// localMolecules.add(recentMolecule);
		// if (recentOccurence == 0) {
		// localOccurence.add(1);
		// } else {
		// localOccurence.add(recentOccurence);
		// }
		// }
		//
		// recentOccurence = 0;
		// recentMolecule = recentChar;
		//
		// } else if (Character.isLowerCase(recentChar.toCharArray()[0])) {
		// recentMolecule = recentMolecule.concat(recentChar);
		//
		// } else if (Character.isDigit(recentChar.toCharArray()[0])) {
		// recentOccurence = recentOccurence * 10 +
		//////////////////////////////////////////////////////////////////////////////// Integer.parseInt(recentChar);
		//
		// } else if (recentChar.equals("[") || recentChar.equals("(")) {
		// verifyMolecule(recentMolecule);
		// if (!recentMolecule.equals("")){
		// localMolecules.add(recentMolecule);
		// if (recentOccurence == 0) {
		// localOccurence.add(1);
		// } else {
		// localOccurence.add(recentOccurence);
		// }
		// }
		// recentMolecule = "";
		// recentOccurence = 0;
		// globalMolecules.addAll(localMolecules);
		// globalOccurence.addAll(localOccurence);
		// localMolecules.clear();
		// localOccurence.clear();
		//
		// } else if (recentChar.equals("]") || recentChar.equals(")")) {
		// verifyMolecule(recentMolecule);
		// if (!recentMolecule.equals("")){
		// localMolecules.add(recentMolecule);
		// if (recentOccurence == 0) {
		// localOccurence.add(1);
		// } else {
		// localOccurence.add(recentOccurence);
		// }
		// }
		//
		// } else {
		// throw new IllegalArgumentException();
		// }
		// }
		//
		// localMolecules.add(recentMolecule);
		// if (recentOccurence == 0) {
		// localOccurence.add(1);
		// } else {
		// localOccurence.add(recentOccurence);
		// }
		//
		// globalMolecules.addAll(localMolecules);
		// globalOccurence.addAll(localOccurence);
		//
		// for (int i = 0; i < globalMolecules.size(); i++) {
		// addMolecule(globalMolecules.get(i), globalOccurence.get(i));
		// }
		///////////////////////////////////////////////////////////////////////////////

		return mol;
	}

//	private static void addMolecule(String molecule, Integer occurence) {
//		ParseMolecule.mol.compute(molecule, (k, v) -> v == null ? occurence : v + occurence);
//	}
	
	private static void addMoleculeToLocalBrackets(String molecule, Integer occurence) {
		moleculesInLocalBrackets.add(molecule);
		if(occurence == 0) {
			occurenceInLocalBrackets.add(1);
		} else {
			occurenceInLocalBrackets.add(occurence);	
		}
	}

	private static void verifyMolecule(String molecule) {
		if (!molecule.equals("") && !atoms.contains(molecule)) {
			throw new IllegalArgumentException();
		}
	}
}
