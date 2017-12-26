package ladder.creator;

import core.NaturalNumber;
import java.util.Random;
import ladder.LadderSize;
import ladder.Position;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private LadderSize ladderSize;
  private Row[] rows;

  public RandomLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
    this.ladderSize = LadderSize.create(height, noOfPerson);
    rows = new Row[height.getNumber()];

    for (int i = 0; i < height.getNumber(); i++) {
      rows[i] = new Row(noOfPerson);
    }

    Position[] startPositions = generateStartPositions();
    for (Position position : startPositions) {
      drawLine(position.getHeight(), position.getNthOfPerson());
    }
  }

  @Override
  public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    if (isOverHeight(height)) {
      throw new IllegalArgumentException(
          String.format("사다리 최대 높이를 넘어섰습니다.현재 값은 : %d", height.getNumber()));
    }

    rows[height.toArrayIndex()].drawLine(startPosition);
  }

  @Override
  public Row[] getLadder() {
    return this.rows;
  }

  private boolean isOverHeight(NaturalNumber height) {
    return height.toArrayIndex() > rows.length - 1;
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
