package ladder.creator;

import core.NaturalNumber;
import java.util.Random;
import ladder.LadderSize;
import ladder.Position;
import ladder.RandomNaturalNumber;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private LadderCreator ladderCreator;
  private LadderSize ladderSize;

  public RandomLadderCreator(LadderCreator ladderCreator) {
    this.ladderCreator = ladderCreator;
    this.ladderSize = ladderCreator.getLadderSize();
    Position[] startPositions = generateStartPositions();
    for (Position position : startPositions) {
      ladderCreator.drawLine(position.getHeight(), position.getNthOfPerson());
    }
  }

  @Override
  public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메서드를 호출할 수 없습니다.");
  }

  @Override
  public Row[] getLadder() {
    return this.ladderCreator.getLadder();
  }

  @Override
  public LadderSize getLadderSize() {
    return this.ladderSize;
  }

  Position[] generateStartPositions() {
    RandomNaturalNumber[] numbers = generateRandomPositions();
    return toPositions(numbers);
  }

  RandomNaturalNumber[] generateRandomPositions() {
    NaturalNumber totalPositions = ladderSize.getTotalPosition();
    int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
    RandomNaturalNumber[] startPositions = new RandomNaturalNumber[countOfLine];

    int i = 0;
    do {
      RandomNaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
      if (ladderSize.isMultipleOfPerson(randomPosition)) {
        continue;
      }
      if (isExisted(startPositions, randomPosition)) {
        continue;
      }

      if (isExisted(startPositions, new RandomNaturalNumber(randomPosition.getNumber() +  1))) {
        continue;
      }

      if (randomPosition.equals(new NaturalNumber(1))) {
        startPositions[i] = randomPosition;
        System.out.println(String.format("random position : %s", startPositions[i]));
        i++;
      } else {
        if (isExisted(startPositions, new RandomNaturalNumber(randomPosition.toArrayIndex()))) {
          continue;
        }

        startPositions[i] = randomPosition;
        System.out.println(String.format("random position : %s", startPositions[i]));
        i++;
      }
    } while (i < countOfLine);

    return startPositions;
  }

  Position[] toPositions(RandomNaturalNumber[] positions) {
    Position[] startPositions = new Position[positions.length];
    for (int i = 0; i < positions.length; i++) {
      startPositions[i] = ladderSize.getPosition(positions[i]);
    }
    return startPositions;
  }

  static RandomNaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new RandomNaturalNumber(rand.nextInt((max - min) + 1) + min);
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
