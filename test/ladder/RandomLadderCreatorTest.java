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

  public void testCountOfLine() {
    int countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(20), 0.3);
    assertEquals(6, countOfLine);

    countOfLine = RandomLadderCreator.getCountOfLine(new NaturalNumber(5), 0.3);
    assertEquals(1, countOfLine);
  }

  public void testConvertTotalPositionsToPosition() {
    Position position = RandomLadderCreator.convertTotalPositionsToPosition(new NaturalNumber(8), new NaturalNumber(4), new NaturalNumber(5));
    assertEquals(Position.create(2,3), position);
  }

  public void testPersonPosition() {
    NaturalNumber positionOfPerson = RandomLadderCreator.getPositionOfPerson(new NaturalNumber(10), new NaturalNumber(3));
    assertEquals(new NaturalNumber(1), positionOfPerson);
  }

  public void testHeightPosition() {
    NaturalNumber positionOfHeight = RandomLadderCreator.getPositionOfHeight(new NaturalNumber(10), new NaturalNumber(3));
    assertEquals(new NaturalNumber(4), positionOfHeight);
  }
}
