package ladder;

import junit.framework.TestCase;

public class RowTest extends TestCase {

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