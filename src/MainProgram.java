/**
 *
 */

import com.boku.shop.Store;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The MainProgram test drives the sales tax project
 */

class MainProgram {

  static List<String> orderItems = new ArrayList<>();
  static Map<Integer, List<String>> orderHash = new HashMap();

  static int numberOfTestCases = 1;

  public static void main(String[] args) {
    String fileName = "input.txt";

    List<String> list = new ArrayList<>();

    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      list = stream.collect(Collectors.toList());
    } catch (IOException e) {
      System.out.println("Error in parsing file");
      e.printStackTrace();
    }

    if (list.size() > 0) {
      list.forEach(
        items -> {
          if (items.contains("Input") && items.contains(":")) {
            if (orderItems.size() > 1) {
              orderHash.put(numberOfTestCases, orderItems);
              numberOfTestCases++;
              orderItems = new ArrayList<>();
            }
          } else orderItems.add(items);
        }
      );
      orderHash.put(numberOfTestCases, orderItems);

      orderHash.forEach(
        (k, v) -> {
          System.out.println("Output: " + k);
          Store store = new Store();
          store.getSalesOrder(v);
          store.checkOut();
        }
      );
    }
  }
}
