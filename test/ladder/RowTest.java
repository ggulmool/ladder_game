package ladder;

import junit.framework.TestCase;

public class RowTest extends TestCase {

  private Row row;

  public void setUp() throws Exception {
    row = new Row(new NaturalNumber(3));
  }

  public void testStartPositionWhenOvernoOfPersons() {
    try {
      row.drawLine(new NaturalNumber(3));
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testDrawLineWhenAlreadyDrawingPoint() {
    try {
      row.drawLine(new NaturalNumber(1));
      row.drawLine(new NaturalNumber(2));
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testMoveWhenNoLine() {
    int target = row.move(0);
    assertEquals(0, target);

    target = row.move(2);
    assertEquals(2, target);
  }

  public void testMoveWhenLineLeft() {
    // 0 1 1
    row.drawLine(new NaturalNumber(2));
    int target = row.move(2);
    assertEquals(1, target);
  }

  public void testMoveWhenLineRight() {
    // 0 1 1
    row.drawLine(new NaturalNumber(2));
    int target = row.move(1);
    assertEquals(2, target);
  }
}