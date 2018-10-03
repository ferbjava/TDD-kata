package com.capgemini;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
      String input = "the_Stealth_Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
      String input = "the-Stealth-Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testLong() {
      String input = "Samurai_Lake_right_Green_Black_Yellow_right_side_river_river_Ninja";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
}