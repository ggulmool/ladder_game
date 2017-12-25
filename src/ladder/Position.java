package ladder;

import core.NaturalNumber;
import java.util.Objects;

class Position {

  private NaturalNumber height;
  private NaturalNumber nthOfPerson;

  private Position(NaturalNumber height, NaturalNumber nthOfPerson) {
    this.height = height;
    this.nthOfPerson = nthOfPerson;
  }

  static Position create(int height, int nthOfPersion) {
    return create(new NaturalNumber(height), new NaturalNumber(nthOfPersion));
  }

  static Position create(NaturalNumber height, NaturalNumber nthOfPersion) {
    return new Position(height, nthOfPersion);
  }

  static Position createFromArrayIndex(int height, int nthOfPerson) {
    return new Position(NaturalNumber.createFromArrayIndex(height), NaturalNumber.createFromArrayIndex(nthOfPerson));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return Objects.equals(height, position.height) &&
        Objects.equals(nthOfPerson, position.nthOfPerson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, nthOfPerson);
  }

  @Override
  public String toString() {
    return "Position{" +
        "height=" + height +
        ", nthOfPerson=" + nthOfPerson +
        '}';
  }
}
