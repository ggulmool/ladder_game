package ladder.creator;

import core.NaturalNumber;
import java.util.List;
import junit.framework.TestCase;
import ladder.Position;

public class RandomLadderCreatorTest extends TestCase {

  public void testGenerateStartPositions() {
    ManualLadderCreator manualLadderCreator = new ManualLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
    RandomLadderCreator creator = new RandomLadderCreator(manualLadderCreator);
    List<Position> positions = creator.generateStartPositions();
    for (Position position : positions) {
      System.out.println(String.format("position : %s", position));

    }
  }
}
