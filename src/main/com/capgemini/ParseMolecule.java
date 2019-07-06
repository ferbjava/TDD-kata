package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParseMolecule {

	private static Map<String, Integer> results = new HashMap<>();

	private static List<String> atoms = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg",
			"Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
			"Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd",
			"In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ti",
			"Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl",
			"Mc", "Lv", "Ts", "Og", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb",
			"Lu", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr");

	private static List<String> localMol = new ArrayList<>();
	private static List<Integer> localNum = new ArrayList<>();

	private static Stack<List<String>> globalMolsStack = new Stack<>();
	private static Stack<List<Integer>> globalIntsStack = new Stack<>();
	private static Stack<String> brackets = new Stack<>();

	public static Map<String, Integer> getAtoms(String formula) {
		results.clear();
		localMol.clear();
		localNum.clear();
		globalIntsStack.clear();
		globalMolsStack.clear();
		brackets.clear();

		String[] strs = formula.split("(?:(?![a-z])(?:(?<!\\d)|(?!\\d)))");

		validateBrackets(Arrays.asList(strs));

		boolean isPreviousMolecule = false;
		boolean isBracketClosed = false;

		for (String str : strs) {
			if (str.matches("[a-zA-Z]*")) {
				checkIfPreviousIsMolecule(isPreviousMolecule);
				verifyMolecule(str);
				localMol.add(str);
				isPreviousMolecule = true;
				isBracketClosed = false;
			} else if (str.matches("\\d*")) {
				if (isBracketClosed) {
					addLocal2Global(Integer.parseInt(str), brackets.size());
				} else {
					localNum.add(Integer.parseInt(str));
				}
				isPreviousMolecule = false;
				isBracketClosed = false;
			} else if (str.matches("\\(|\\[|\\{")) {
				checkIfPreviousIsMolecule(isPreviousMolecule);
				checkBrackets(brackets.size());
				isPreviousMolecule = false;
				isBracketClosed = false;
				brackets.push(str);
			} else if (str.matches("\\)|\\]|\\}")) {
				checkIfPreviousIsMolecule(isPreviousMolecule);
				checkIfCorrectBracket(str);
				isPreviousMolecule = false;
				isBracketClosed = true;
			} else {
				throw new IllegalArgumentException();
			}
		}

		if (!localMol.isEmpty()) {
			if (isPreviousMolecule) {
				localNum.add(1);
			}
			addToResults(localMol, localNum);
		}

		while (!globalMolsStack.isEmpty()) {
			addToResults(globalMolsStack.pop(), globalIntsStack.pop());
		}

		return results;
	}

	private static void validateBrackets(List<String> list) {
		Integer leftRound = 0;
		Integer rightRound = 0;
		Integer leftSquare = 0;
		Integer rightSquare = 0;
		Integer leftCurly = 0;
		Integer rightCurly = 0;

		for (String c : list) {
			switch (c) {
			case "(":
				leftRound++;
				break;
			case ")":
				rightRound++;
				break;
			case "[":
				leftSquare++;
				break;
			case "]":
				rightSquare++;
				break;
			case "{":
				leftCurly++;
				break;
			case "}":
				rightCurly++;
				break;
			default:
				break;
			}
		}

		if ((leftRound != rightRound) || (leftSquare != rightSquare)) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkIfCorrectBracket(String str) {
		switch (str) {
		case ")":
			if(!brackets.peek().equals("(")) throw new IllegalArgumentException();
			break;
		case "]":
			if(!brackets.peek().equals("[")) throw new IllegalArgumentException();
			break;
		case "}":
			if(!brackets.peek().equals("{")) throw new IllegalArgumentException();
			break;
		default:
			break;
		}
		brackets.pop();
	}

	private static void addLocal2Global(Integer mult, int inBrackets) {
		if (localMol.isEmpty()) {
			localMol.addAll(globalMolsStack.pop());
			localNum.addAll(globalIntsStack.pop());
		}
		for (int i = 0; i < localNum.size(); i++) {
			localNum.set(i, localNum.get(i) * mult);
		}

		List<String> mols = new ArrayList<>();
		List<Integer> occurs = new ArrayList<>();

		if (!globalIntsStack.isEmpty()) {
			mols = globalMolsStack.pop();
			occurs = globalIntsStack.pop();
		}
		mols.addAll(localMol);
		occurs.addAll(localNum);

		globalMolsStack.push(new ArrayList<String>(mols));
		globalIntsStack.push(new ArrayList<Integer>(occurs));

		localMol.clear();
		localNum.clear();
	}

	private static void checkBrackets(int inBrackets) {
		if (inBrackets == 0) {
			addToResults(localMol, localNum);
		} else if (!localMol.isEmpty()) {
			globalMolsStack.push(new ArrayList<String>(localMol));
			globalIntsStack.push(new ArrayList<Integer>(localNum));
		}
		localMol.clear();
		localNum.clear();
	}

	private static void addToResults(List<String> localMol, List<Integer> localNum) {
		for (int i = 0; i < localMol.size(); i++) {
			String molecule = localMol.get(i);
			Integer occurence = localNum.get(i);
			results.compute(molecule, (k, v) -> v == null ? occurence : v + occurence);
		}
	}

	private static void checkIfPreviousIsMolecule(boolean isPreviousMolecule) {
		if (isPreviousMolecule) {
			localNum.add(1);
		}
	}

	private static void verifyMolecule(String molecule) {
		if (!molecule.equals("") && !atoms.contains(molecule)) {
			throw new IllegalArgumentException();
		}
	}

}
