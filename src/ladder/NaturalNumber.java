package ladder;

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
}
