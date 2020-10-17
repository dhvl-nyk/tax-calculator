package com.boku.billing;

import static org.junit.Assert.assertEquals;

import com.boku.products.Product;
import com.boku.taxcalculations.ITaxCalculator;
import com.boku.taxcalculations.impl.IndiaTaxCalculatorImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mockit.Mock;
import org.junit.Before;
import org.junit.Test;

public class BillGeneratorTest {

  ITaxCalculator taxCalculator = new IndiaTaxCalculatorImpl();
  private BillGenerator billGeneratorUnderTest;
  private Product product;
  private List<Product> productList = new ArrayList<>();

  @Before
  public void setUp() {
    product = new Product("book", 10.01, true, 1, "bookProduct");
    productList.add(product);
    product =
      new Product(
        "packet of headache pills",
        20.10,
        false,
        1,
        "MedicalProduct"
      );
    productList.add(product);
    billGeneratorUnderTest = new BillGenerator(taxCalculator);
  }

  @Test
  public void testCalculateTax() {
    // Setup
    final double result = billGeneratorUnderTest.calculateTax(27.99, 0.1, true);
    // Verify the results
    assertEquals(4.199, result, 0.1);
  }

  @Test
  public void testCalcTotalProductPrice() {
    // Setup

    // Run the test
    final double result = billGeneratorUnderTest.calcTotalProductPrice(
      27.99,
      4.2
    );
    // Verify the results
    assertEquals(32.19, result, 0.0001);
  }
}
