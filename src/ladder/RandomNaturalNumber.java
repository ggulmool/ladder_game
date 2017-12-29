package ladder;

import core.NaturalNumber;

public class RandomNaturalNumber extends NaturalNumber {

  public RandomNaturalNumber(int number) {
    super(number);
  }

  public int getPositionOfPerson(int noOfPerson) {
    int remainder = this.getNumber() % noOfPerson;
    if (remainder == 0) {
      return noOfPerson;
    }
    return remainder;
  }

  public int getPositionOfHeight(int noOfPerson) {
    double ceilDevideEnd = Math.ceil(this.getNumber() / (double) noOfPerson);
    return new Double(ceilDevideEnd).intValue();
  }

  public boolean isMultipleOfPerson(int noOfPerson) {
    int remainder = this.getNumber() % noOfPerson;
    if (remainder == 0) {
      return true;
    }
    return false;
  }
}
