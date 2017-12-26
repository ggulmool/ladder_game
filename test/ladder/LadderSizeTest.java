package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class LadderSizeTest extends TestCase {

  private LadderSize size;

  public void setUp() throws Exception {
    size = LadderSize.create(3, 4);
  }

  public void testGetPositionOfPerson() {
    NaturalNumber actual = size.getPositionOfPerson(new NaturalNumber(5));
    assertEquals(new NaturalNumber(1), actual);
  }

  public void testGetPositionOfHeight() {
    NaturalNumber actual = size.getPositionOfHeight(new NaturalNumber(5));
    assertEquals(new NaturalNumber(2), actual);
  }

  public void testConvertTotalPositionsToPosition() {
    Position actual = size.getPosition(new NaturalNumber(5));
    assertEquals(Position.create(2,1), actual);
  }

  public void testIsMultipleOfPerson() {
    assertTrue(size.isMultipleOfPerson(new NaturalNumber(8)));
    assertFalse(size.isMultipleOfPerson(new NaturalNumber(7)));
  }
}
