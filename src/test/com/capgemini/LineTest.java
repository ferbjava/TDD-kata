package com.capgemini;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {

	@Test
	public void test1() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 1;
		assertEquals("Sheldon", Line.WhoIsNext(names, n));
	}

	@Test
	public void test2() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 6;
		assertEquals("Sheldon", Line.WhoIsNext(names, n));
	}

	@Test
	public void test3() {
		String[] names = new String[] { "Sheldon", "Leonard" };
		int n = 20;
		assertEquals("Sheldon", Line.WhoIsNext(names, n));
	}

	@Test
	public void test4() {
		String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
		int n = 52;
		assertEquals("Penny", Line.WhoIsNext(names, n));
	}

	@Test
	public void test5() {
		String[] names = new String[] { "Sheldon" };
		int n = 1;
		assertEquals("Sheldon", Line.WhoIsNext(names, n));
	}

}
