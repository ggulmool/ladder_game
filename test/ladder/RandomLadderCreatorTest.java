package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class RandomLadderCreatorTest extends TestCase {

  public void testGenerateStartPositions() {
    RandomLadderCreator creator = new RandomLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
    Position[] positions = creator.generateStartPositions();
    for (int i = 0; i < positions.length; i++) {
      System.out.println(String.format("position : %s", positions[i]));
    }
  }

  public void testIsExisted() {
    NaturalNumber[] startPositions = {new NaturalNumber(2), new NaturalNumber(3)};
    assertTrue(RandomLadderCreator.isExisted(startPositions, new NaturalNumber(2)));
    assertFalse(RandomLadderCreator.isExisted(startPositions, new NaturalNumber(4)));
  }
}
