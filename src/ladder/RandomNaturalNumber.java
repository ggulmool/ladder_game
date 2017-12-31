package ladder;

import core.NaturalNumber;
import java.util.ArrayList;
import java.util.List;

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

  public RandomNaturalNumber before() {
    return new RandomNaturalNumber(toArrayIndex());
  }

  public RandomNaturalNumber next() {
    return new RandomNaturalNumber(getNumber() + 1);
  }

  public List<NaturalNumber> checkedNaturalNumbers(NaturalNumber noOfPerson) {
    List<NaturalNumber> naturalNumbers = new ArrayList<>();

    int remainder = this.getNumber() % noOfPerson.getNumber();
    if (!isFirst(remainder)) {
      naturalNumbers.add(before());
    }
    naturalNumbers.add(this);
    naturalNumbers.add(next());
    return naturalNumbers;
  }
}
