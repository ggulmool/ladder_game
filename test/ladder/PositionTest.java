package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class PositionTest extends TestCase {

  public void testCreate() {
    Position position = Position.create(new NaturalNumber(3), new NaturalNumber(4));
    Position position2 = Position.create(3, 4);
    assertEquals(position, position2);
  }

  public void testCreateFromArrayIndex() {
    Position arrayPosition = Position.createFromArrayIndex(2, 3);
    Position position = Position.create(new NaturalNumber(3), new NaturalNumber(4));
    assertEquals(position, arrayPosition);
  }
}
