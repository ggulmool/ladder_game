package ladder;

import core.NaturalNumber;
import java.util.Random;

class RandomLadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private LadderSize ladderSize;
  private Row[] rows;

  RandomLadderCreator(LadderSize ladderSize) {
    NaturalNumber height = ladderSize.getHeight();
    NaturalNumber noOfPerson = ladderSize.getNoOfPerson();
    this.ladderSize = ladderSize;
    rows = new Row[height.getNumber()];

    for (int i = 0; i < height.getNumber(); i++) {
      rows[i] = new Row(noOfPerson);
    }
  }

  void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    if (isOverHeight(height)) {
      throw new IllegalArgumentException(
          String.format("사다리 최대 높이를 넘어섰습니다.현재 값은 : %d", height.getNumber()));
    }

    rows[height.toArrayIndex()].drawLine(startPosition);
  }

  private boolean isOverHeight(NaturalNumber height) {
    return height.toArrayIndex() > rows.length - 1;
  }

  Row[] getLadder() {
    return this.rows;
  }

  Position[] generateStartPositions() {
    NaturalNumber[] numbers = generateRandomPositions();
    return toPositions(numbers);
  }

  Position[] toPositions(NaturalNumber[] positions) {
    Position[] startPositions = new Position[positions.length];
    for (int i = 0; i < positions.length; i++) {
      startPositions[i] = ladderSize.getPosition(positions[i]);
    }
    return startPositions;
  }

  NaturalNumber[] generateRandomPositions() {
    NaturalNumber totalPositions = ladderSize.getTotalPosition();
    int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
    NaturalNumber[] startPositions = new NaturalNumber[countOfLine];
    for (int i = 0; i < startPositions.length; i++) {
      startPositions[i] = randInt(1, totalPositions.getNumber());
      System.out.println(String.format("random position : %s", startPositions[i]));
    }
    return startPositions;
  }

  static NaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new NaturalNumber(rand.nextInt((max - min) + 1) + min);
  }
}
