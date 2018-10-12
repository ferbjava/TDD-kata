package com.capgemini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseMolecule {

	private static List<String> atoms = Arrays.asList("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
			"Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga",
			"Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In",
			"Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ti", "Pb",
			"Bi", "Po", "At", "Rn");

	public static Map<String, Integer> getAtoms(String formula) {
		List<String> str = Arrays.stream(formula.split("")).collect(Collectors.toList());
		List<String> molecules = new ArrayList<>();
		List<Integer> occur = new ArrayList<>();
		List<Integer> leftBrackets = new ArrayList<>();
		List<Integer> rightBrackets = new ArrayList<>();
		Map<String, Integer> mol = new HashMap<>();
		mol.put("O", 3);
		mol.put("N", 2);
		mol.put("Ca", 1);
		System.out.println(mol.toString());
		
		for(int i = 0; i < str.size(); i++) {
			String recentChar = str.get(i);
			if(Character.isLetter(recentChar.toCharArray()[0])) {
				String nextChar = str.get(i+1);
				if(Character.isLetter(nextChar.toCharArray()[0])) {
					String molecule = recentChar.concat(nextChar);
					if(ParseMolecule.atoms.contains(molecule)) {
						
					}
				}
			}
		}
		
		Iterator<String> stringIterator = str.iterator();
		while(stringIterator.hasNext()){
			String recentChar = stringIterator.next();
			if(Character.isLetter(recentChar.toCharArray()[0])) {
				String nextChar = stringIterator.next();
			}
		}
		
		for(String s: str){
			if(Character.isLetter(s.toCharArray()[0])){
				
			}
		}
		
		char[] chars = formula.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLetter(chars[i])) {
				
			}
		}
		
		return new HashMap<String, Integer>();
	}
}
