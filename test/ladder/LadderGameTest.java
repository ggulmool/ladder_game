package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class LadderGameTest extends TestCase {
  public void testRunWhenMultiRows() {
    // 1 -1 0 0
    // 0 1 -1 0
    // 0 0 1 -1
    LadderGame ladderGame = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
    ladderGame.drawLine(new NaturalNumber(1), new NaturalNumber(1));
    ladderGame.drawLine(new NaturalNumber(2), new NaturalNumber(2));
    ladderGame.drawLine(new NaturalNumber(3), new NaturalNumber(3));

    assertEquals(new Marker(4), ladderGame.run(new Marker(1)));
    assertEquals(new Marker(1), ladderGame.run(new Marker(2)));
    assertEquals(new Marker(2), ladderGame.run(new Marker(3)));
    assertEquals(new Marker(3), ladderGame.run(new Marker(4)));
  }

  public void testDrawLineWhenOverNoOfRows() {
    try {
      LadderGame ladderGame = new LadderGame(new NaturalNumber(3), new NaturalNumber(4));
      ladderGame.drawLine(new NaturalNumber(4), new NaturalNumber(4));
      fail("IllegalArgumentException 에러가 발생해야 한다.");
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
  }
}
