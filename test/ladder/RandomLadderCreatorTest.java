package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class RandomLadderCreatorTest extends TestCase {

  public void testGenerateStartPositions() {
    RandomLadderCreator creator = new RandomLadderCreator(LadderSize.create(3, 4));
    Position[] positions = creator.generateStartPositions();
    for (int i = 0; i < positions.length; i++) {
      System.out.println(String.format("position : %s", positions[i]));
    }
  }
}
