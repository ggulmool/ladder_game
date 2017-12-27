package ladder.creator;

import core.NaturalNumber;
import java.util.Random;
import ladder.LadderSize;
import ladder.Position;

public class RandomLadderCreator extends ManualLadderCreator implements LadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private LadderSize ladderSize;

  public RandomLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
    super(height, noOfPerson);
    this.ladderSize = LadderSize.create(height, noOfPerson);

    Position[] startPositions = generateStartPositions();
    for (Position position : startPositions) {
      super.drawLine(position.getHeight(), position.getNthOfPerson());
    }
  }

  @Override
  public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메서드를 호출할 수 없습니다.");
  }

  Position[] generateStartPositions() {
    NaturalNumber[] numbers = generateRandomPositions();
    return toPositions(numbers);
  }

  NaturalNumber[] generateRandomPositions() {
    NaturalNumber totalPositions = ladderSize.getTotalPosition();
    int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
    NaturalNumber[] startPositions = new NaturalNumber[countOfLine];

    int i = 0;
    do {
      NaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
      if (ladderSize.isMultipleOfPerson(randomPosition)) {
        continue;
      }
      if (isExisted(startPositions, randomPosition)) {
        continue;
      }

      if (isExisted(startPositions, new NaturalNumber(randomPosition.getNumber() +  1))) {
        continue;
      }

      if (randomPosition.equals(new NaturalNumber(1))) {
        startPositions[i] = randomPosition;
        System.out.println(String.format("random position : %s", startPositions[i]));
        i++;
      } else {
        if (isExisted(startPositions, new NaturalNumber(randomPosition.toArrayIndex()))) {
          continue;
        }

        startPositions[i] = randomPosition;
        System.out.println(String.format("random position : %s", startPositions[i]));
        i++;
      }
    } while (i < countOfLine);

    return startPositions;
  }

  Position[] toPositions(NaturalNumber[] positions) {
    Position[] startPositions = new Position[positions.length];
    for (int i = 0; i < positions.length; i++) {
      startPositions[i] = ladderSize.getPosition(positions[i]);
    }
    return startPositions;
  }

  static NaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new NaturalNumber(rand.nextInt((max - min) + 1) + min);
  }

  static boolean isExisted(NaturalNumber[] startPositions, NaturalNumber randomPosition) {
    for (NaturalNumber position : startPositions) {
      if (randomPosition.equals(position)) {
        return true;
      }
    }
    return false;
  }
}
