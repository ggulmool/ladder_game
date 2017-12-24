package ladder;

import junit.framework.TestCase;

public class LadderTest extends TestCase {

  public void testNoOfHeight() {
    try {
      new Ladder(new NaturalNumber(0), new NaturalNumber(4));
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testHeightWhenOvernoOfRows() {
    try {
      Ladder ladder = new Ladder(new NaturalNumber(2), new NaturalNumber(1));
      ladder.drawLine(new NaturalNumber(4), new NaturalNumber(4));
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      assertTrue(true);
    }
  }

  public void testRunWhenMultiRows() {
    // 1 1 0 0
    // 0 1 1 0
    // 0 0 1 1
    Ladder ladder = new Ladder(new NaturalNumber(3), new NaturalNumber(4));
    ladder.drawLine(new NaturalNumber(1), new NaturalNumber(1));
    ladder.drawLine(new NaturalNumber(2), new NaturalNumber(2));
    ladder.drawLine(new NaturalNumber(3), new NaturalNumber(3));

    assertEquals(3, ladder.run(0));
    assertEquals(0, ladder.run(1));
    assertEquals(1, ladder.run(2));
    assertEquals(2, ladder.run(3));
  }
}
