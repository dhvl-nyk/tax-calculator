package com.boku.products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiscellaneousProductTest {

    private MiscellaneousProduct miscellaneousProductUnderTest;

    @Before
    public void setUp() {
        miscellaneousProductUnderTest = new MiscellaneousProduct("imported bottle of perfume", 220.0, true, 1);
    }

    @Test
    public void testCreateProduct() {
        // Verify the results
        assertEquals("imported bottle of perfume", miscellaneousProductUnderTest.getName());
        assertEquals(220.0, miscellaneousProductUnderTest.getPrice(), 0.0);
        assertEquals(true, miscellaneousProductUnderTest.isImported());
        assertEquals(1, miscellaneousProductUnderTest.getQuantity());
    }
}
