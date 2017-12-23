package ladder;

import junit.framework.TestCase;

public class LadderTest extends TestCase {

  public void testRunWhenNoLine() {
    int noOfPerson = 1;
    Ladder ladder = new Ladder(1);
    int target = ladder.run(noOfPerson);
    assertEquals(noOfPerson, target);

    target = ladder.run(2);
    assertEquals(2, target);
  }

  public void testRunWhenTwoByOne1Line() {
    // 1 1
    Ladder ladder = new Ladder(2);
    ladder.drawLine(0);
    int target = ladder.run(1);
    assertEquals(2, target);
  }

  public void testRunWhenThreeByOne1Line() {
    // 1 1 0
    Ladder ladder = new Ladder(3);
    ladder.drawLine(0);
    int target = ladder.run(1);
    assertEquals(2, target);

    target = ladder.run(2);
    assertEquals(1, target);

    target = ladder.run(3);
    assertEquals(3, target);

  }

  public void testRunWhenThreeByOne1Line2() {
    // 0 1 1
    Ladder ladder = new Ladder(3);
    ladder.drawLine(1);
    int target = ladder.run(1);
    assertEquals(1, target);

    target = ladder.run(2);
    assertEquals(3, target);

    target = ladder.run(3);
    assertEquals(2, target);
  }
}
