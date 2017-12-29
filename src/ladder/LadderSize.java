package ladder;

import core.NaturalNumber;

public class LadderSize {

  private NaturalNumber height;
  private NaturalNumber noOfPerson;

  private LadderSize(NaturalNumber height, NaturalNumber noOfPerson) {
    this.height = height;
    this.noOfPerson = noOfPerson;
  }

  NaturalNumber getHeight() {
    return height;
  }

  NaturalNumber getNoOfPerson() {
    return noOfPerson;
  }

  static LadderSize create(int height, int noOfPerson) {
    return new LadderSize(new NaturalNumber(height), new NaturalNumber(noOfPerson));
  }

  public static LadderSize create(NaturalNumber height, NaturalNumber nthOfPersion) {
    return new LadderSize(height, nthOfPersion);
  }

  public Position getPosition(RandomNaturalNumber randomNaturalNumber) {
    int positionOfHeight = randomNaturalNumber.getPositionOfHeight(noOfPerson.getNumber());
    int positionOfPerson = randomNaturalNumber.getPositionOfHeight(noOfPerson.getNumber());
    return Position.create(positionOfHeight, positionOfPerson);
  }

  public int getCountOfLine(double ratio) {
    NaturalNumber totalPositions = getTotalPosition();
    return (int) (totalPositions.getNumber() * ratio);
  }

  public NaturalNumber getTotalPosition() {
    return height.multiply(noOfPerson);
  }

  public boolean isMultipleOfPerson(RandomNaturalNumber randomPosition) {
    return randomPosition.isMultipleOfPerson(noOfPerson.getNumber());
  }
}
