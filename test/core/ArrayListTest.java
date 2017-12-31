package core;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class ArrayListTest extends TestCase {

  public void testRetainAll() {
    List<Integer> values = new ArrayList<>();
    values.add(1);
    values.add(2);
    values.add(3);
    List<Integer> values2 = new ArrayList<>();
    values2.add(2);
    values2.add(3);

    values.retainAll(values2);
    //System.out.println(values);
    //System.out.println(values2);
    assertTrue(values.size() == 2);
  }

  public void testRetainAll2() {
    List<Integer> values = new ArrayList<>();
    values.add(1);
    values.add(2);
    values.add(3);
    List<Integer> values2 = new ArrayList<>();
    values2.add(4);

    values.retainAll(values2);
    //System.out.println(values);
    //System.out.println(values2);
    assertTrue(values.size() == 0);
  }
}
