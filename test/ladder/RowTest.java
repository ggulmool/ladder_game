package ladder;

import core.NaturalNumber;
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
    NaturalNumber target = row.move(new Marker(1));
    assertEquals(1, target.getNumber());

    target = row.move(new Marker(3));
    assertEquals(3, target.getNumber());
  }

  public void testMoveWhenLineLeft() {
    // 0 1 1
    row.drawLine(new NaturalNumber(2));
    NaturalNumber target = row.move(new Marker(3));
    assertEquals(2, target.getNumber());
  }

  public void testMoveWhenLineRight() {
    // 0 1 1
    row.drawLine(new NaturalNumber(2));
    NaturalNumber target = row.move(new Marker(2));
    assertEquals(3, target.getNumber());
  }
}