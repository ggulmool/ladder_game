package ladder;

class Marker extends NaturalNumber {

  Marker(int number) {
    super(number);
  }

  public Marker moveRight() {
    return new Marker(getNumber() + 1);
  }

  public Marker moveLeft() {
    return new Marker(getNumber() - 1);
  }
}
