package ladder;

import java.util.Objects;

class NaturalNumber {

  private int number;

  NaturalNumber(int number) {
    if (number < 1) {
      throw new IllegalArgumentException(String.format("자연수는 1 이상이어야 합니다. 현재 값은 : %d", number));
    }
    this.number = number;
  }

  int getNumber() {
    return this.number;
  }

  int toArrayIndex() {
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
