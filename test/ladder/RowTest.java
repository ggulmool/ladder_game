package ladder;

import junit.framework.TestCase;

public class RowTest extends TestCase {

  public void testNoOfPersons() {
    try {
      new Row(0);
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testStartPositionWhenMinus() {
    Row row = new Row(3);
    try {
      row.drawLine(-1);
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testStartPositionWhenOvernoOfPersons() {
    Row row = new Row(3);
    try {
      row.drawLine(2);
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testDrawLineWhenAlreadyDrawingPoint() {
    Row row = new Row(3);
    try {
      row.drawLine(0);
      row.drawLine(1);
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testMoveWhenNoLine() {
    Row row = new Row(3);
    int target = row.move(0);
    assertEquals(0, target);

    target = row.move(2);
    assertEquals(2, target);
  }

  public void testMoveWhenLineLeft() {
    // 0 1 1
    Row row = new Row(3);
    row.drawLine(1);
    int target = row.move(2);
    assertEquals(1, target);
  }

  public void testMoveWhenLineRight() {
    // 0 1 1
    Row row = new Row(3);
    row.drawLine(1);
    int target = row.move(1);
    assertEquals(2, target);
  }
}