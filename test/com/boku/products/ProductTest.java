package com.boku.products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Product productUnderTest;

    @Before
    public void setUp() {
        productUnderTest = new Product("book", 12.49, false, 1, "bookProduct");
    }

    @Test
    public void testGetName() {
        assertEquals("book", productUnderTest.getName());
    }

    @Test
    public void testGetPrice()
    {
        assertEquals(12.49, productUnderTest.getPrice(), 0.0009);
    }

    @Test
    public void testIsImported()
    {
        assertEquals(false, productUnderTest.isImported());
    }

    @Test
    public void testGetTaxedCost() {
        assertEquals(0.0, productUnderTest.getTaxedCost(), 0.0009);
    }
}
