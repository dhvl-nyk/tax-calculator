package com.boku.shop;

import com.boku.products.FoodProduct;
import com.boku.products.FoodProductTest;
import com.boku.products.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoreShelfTest {

    private StoreShelf storeShelfUnderTest;

    @Before
    public void setUp() {
        storeShelfUnderTest = new StoreShelf();
    }

    @Test
    public void testSearchAndRetrieveItemFromShelf() {
        // Setup
        final Product result = storeShelfUnderTest.searchAndRetrieveItemFromShelf("imported bottle of perfume", 32.19, true, 1);

        // Run the test
        assertEquals("imported bottle of perfume", result.getName());
        assertEquals(32.19, result.getPrice(), 0.0009);
        assertEquals(true, result.isImported());
        assertEquals(1, result.getQuantity());
    }

//    @Test
//    public void testGetShelfSize() {
//        // Setup
//
//        // Run the test
//        final int result = storeShelfUnderTest.getShelfSize();
//
//        // Verify the results
//        assertEquals(0, result);
//    }
}
