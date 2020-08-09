package com.boku.products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodProductTest {

    private FoodProduct foodProductUnderTest;

    @Before
    public void setUp() {
        foodProductUnderTest = new FoodProduct("chocolate bar", 0.85, false, 1);
    }

    @Test
    public void testCreateProduct() {
        // Verify the results
		assertEquals("chocolate bar", foodProductUnderTest.getName());
		assertEquals(0.85, foodProductUnderTest.getPrice(), 0.0009);
		assertEquals(false, foodProductUnderTest.isImported());
		assertEquals(1, foodProductUnderTest.getQuantity());
    }

}
