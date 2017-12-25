package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class LadderSizeTest extends TestCase {

  public void testGetPositionOfPerson() {
    LadderSize size = LadderSize.create(3, 4);
    NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
    assertEquals(new NaturalNumber(1), actual);
  }

  public void testGetPositionOfHeight() {
    LadderSize size = LadderSize.create(3, 4);
    NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
    assertEquals(new NaturalNumber(2), actual);
  }

  public void testConvertTotalPositionsToPosition() {
    LadderSize size = LadderSize.create(3, 4);
    Position actual = size.getPosition(new NaturalNumber(5));
    assertEquals(Position.create(2,1), actual);
  }
}
