package com.boku.taxcalculations.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IndiaTaxCalculatorImplTest {

  private IndiaTaxCalculatorImpl indiaTaxCalculatorImplUnderTest;

  @Before
  public void setUp() {
    indiaTaxCalculatorImplUnderTest = new IndiaTaxCalculatorImpl();
  }

  @Test
  public void testCalculateTax() {
    // Verify the results
    assertEquals(
      0.50,
      indiaTaxCalculatorImplUnderTest.calculateTax(10.00, 0, true),
      0
    );
    assertEquals(
      1.50,
      indiaTaxCalculatorImplUnderTest.calculateTax(14.99, 0.10, false),
      0
    );
  }
}
