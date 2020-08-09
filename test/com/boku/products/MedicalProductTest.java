package com.boku.products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalProductTest {

    private MedicalProduct medicalProductUnderTest;

    @Before
    public void setUp() {
        medicalProductUnderTest = new MedicalProduct("packet of headache pills", 11.0, true, 2);
    }

    @Test
    public void testCreateProduct() {
        // Verify the results
        assertEquals("packet of headache pills", medicalProductUnderTest.getName());
        assertEquals(22.0, medicalProductUnderTest.getPrice(), 0.0009);
        assertEquals(true, medicalProductUnderTest.isImported());
        assertEquals(2, medicalProductUnderTest.getQuantity());
    }
}
