package core;

import java.util.Objects;

public class NaturalNumber {

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
    return this.number - 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NaturalNumber that = (NaturalNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
