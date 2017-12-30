package core;

import java.util.Objects;

public class NaturalNumber {

  private static final int INTERVAL = 1;
  private static final int FIRST_OF_NATURAL_NUMBER = 1;
  private int number;

  public NaturalNumber(int number) {
    if (number < 1) {
      throw new IllegalArgumentException(String.format("자연수는 1 이상이어야 합니다. 현재 값은 : %d", number));
    }
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  public int toArrayIndex() {
    return this.number - INTERVAL;
  }

  public NaturalNumber multiply(NaturalNumber operand) {
    return new NaturalNumber(this.number * operand.number);
  }

  public static NaturalNumber createFromArrayIndex(int index) {
    return new NaturalNumber(index + INTERVAL);
  }

  public boolean isFirst() {
    return this.getNumber() == FIRST_OF_NATURAL_NUMBER;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NaturalNumber)) {
      return false;
    }
    NaturalNumber that = (NaturalNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {

    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return number + "";
  }
}
