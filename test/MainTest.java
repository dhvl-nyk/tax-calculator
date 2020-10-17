import static org.junit.Assert.assertEquals;

import com.boku.shop.Store;
import org.junit.Test;

public class MainTest {

  Store store = new Store();

  /**
   * Test case for non-imported products: (Test Input 1)
   * * */
  @Test
  public void testNonImportedProducts() {
    store.retrieveOrderAndCheckIn("book", 12.49, false, 1);
    store.retrieveOrderAndCheckIn("music CD", 14.99, false, 1);
    store.retrieveOrderAndCheckIn("chocolate bar", 0.85, false, 1);
    store.getPaymentCounter().billItemsInCart(store.getCart());
    assertEquals(
      "Total Sales Taxes ",
      1.50,
      store.getPaymentCounter().getReceipt().getTotalSalesTax(),
      0
    );
    assertEquals(
      "Total amount ",
      29.83,
      store.getPaymentCounter().getReceipt().getTotalAmount(),
      0
    );
  }

  /**
   * Test case for imported products: (Test Input 2)
   */
  @Test
  public void testImportedProducts() {
    store.retrieveOrderAndCheckIn("imported box of chocolates", 10, true, 1);
    store.retrieveOrderAndCheckIn("imported bottle of perfume", 47.50, true, 1);
    store.getPaymentCounter().billItemsInCart(store.getCart());
    assertEquals(
      "Total Sales Taxes",
      7.65,
      store.getPaymentCounter().getReceipt().getTotalSalesTax(),
      0
    );
    assertEquals(
      "Total amount",
      65.15,
      store.getPaymentCounter().getReceipt().getTotalAmount(),
      0
    );
  }

  /**
   * 	Test case for both imported and non-imported products: (Test Input 3)
   */
  @Test
  public void testGeneralCase() {
    store.retrieveOrderAndCheckIn("imported bottle of perfume", 27.99, true, 1);
    store.retrieveOrderAndCheckIn("bottle of perfume", 18.99, false, 1);
    store.retrieveOrderAndCheckIn("packet of headache pills", 9.75, false, 1);
    store.retrieveOrderAndCheckIn("box of imported chocolates", 11.25, true, 1);
    store.getPaymentCounter().billItemsInCart(store.getCart());
    assertEquals(
      "Total Sales Taxes",
      6.70,
      store.getPaymentCounter().getReceipt().getTotalSalesTax(),
      0
    );
    assertEquals(
      "Total amount",
      74.68,
      store.getPaymentCounter().getReceipt().getTotalAmount(),
      0
    );
  }

  /** Test case for tax exempt items which are imported */
  @Test
  public void testTaxExemptImportedProducts() {
    store.retrieveOrderAndCheckIn("imported bottle of perfume", 32.49, true, 1);
    store.retrieveOrderAndCheckIn("box of imported chocolates", 20.75, true, 1);
    store.retrieveOrderAndCheckIn("imported box of chocolates", 30, true, 1);
    store.getPaymentCounter().billItemsInCart(store.getCart());
    assertEquals(
      "Total Sales Taxes",
      7.45,
      store.getPaymentCounter().getReceipt().getTotalSalesTax(),
      0
    );
    assertEquals(
      "Total amount payable for all products",
      90.69,
      store.getPaymentCounter().getReceipt().getTotalAmount(),
      0
    );
  }
}
