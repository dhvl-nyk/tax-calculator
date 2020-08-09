package com.boku.products;

import org.junit.Before;
import org.junit.Test;

import static com.boku.util.Constants.INDIA;
import static org.junit.Assert.assertEquals;

public class BookProductTest {

    private BookProduct bookProductUnderTest;

    @Before
    public void setUp() {
        bookProductUnderTest = new BookProduct("book", 12.49, false, 1);
    }

    @Test
    public void testCreateProduct() {
        // Verify the results
        assertEquals("book", bookProductUnderTest.getName());
        assertEquals(12.49, bookProductUnderTest.getPrice(), 0.0);
        assertEquals(false, bookProductUnderTest.isImported());
        assertEquals(1, bookProductUnderTest.getQuantity());
    }

}
