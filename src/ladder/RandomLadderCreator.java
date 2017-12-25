package ladder;

import core.NaturalNumber;
import java.util.Random;

class RandomLadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private NaturalNumber totalPositions;
  private NaturalNumber height;
  private NaturalNumber noOfPerson;
  private Row[] rows;

  RandomLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
    this.totalPositions = height.multiply(noOfPerson);
    this.height = height;
    this.noOfPerson = noOfPerson;

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
      startPositions[i] = convertTotalPositionsToPosition(positions[i], height, noOfPerson);
    }
    return startPositions;
  }

  NaturalNumber[] generateRandomPositions() {
    int countOfLine = getCountOfLine(totalPositions, DEFAULT_LINE_RATIO);
    NaturalNumber[] startPositions = new NaturalNumber[countOfLine];
    for (int i = 0; i < startPositions.length; i++) {
      startPositions[i] = randInt(1, totalPositions.getNumber());
      System.out.println(String.format("random position : %s", startPositions[i]));
    }
    return startPositions;
  }

  static int getCountOfLine(NaturalNumber totalPositions, double ratio) {
    return (int) (totalPositions.getNumber() * ratio);
  }

  static NaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new NaturalNumber(rand.nextInt((max - min) + 1) + min);
  }

  static Position convertTotalPositionsToPosition(NaturalNumber totalPositions, NaturalNumber height, NaturalNumber noOfPerson) {
    NaturalNumber positionOfHeight = getPositionOfHeight(totalPositions, noOfPerson);
    NaturalNumber positionOfPerson = getPositionOfPerson(totalPositions, noOfPerson);
    return Position.create(positionOfHeight, positionOfPerson);
  }

  static NaturalNumber getPositionOfPerson(NaturalNumber totalPositions, NaturalNumber noOfPerson) {
    int remainder = totalPositions.getNumber() % noOfPerson.getNumber();
    if (remainder == 0) {
      return noOfPerson;
    }
    return new NaturalNumber(remainder);
  }

  static NaturalNumber getPositionOfHeight(NaturalNumber totalPositions, NaturalNumber noOfPerson) {
    double ceilDevideEnd = Math.ceil(totalPositions.getNumber() / (double) noOfPerson.getNumber());
    return new NaturalNumber(new Double(ceilDevideEnd).intValue());
  }
}
