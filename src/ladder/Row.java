package ladder;

public class Row {

  int[] persons;

  public Row(int noOfPerson) {
    persons = new int[noOfPerson];
  }

  void drawLine(int startPosition) {
    persons[startPosition] = 1;
    persons[startPosition + 1] = -1;
  }

  int move(int nthOfPerson) {
    if (isNoLine(nthOfPerson)) {
      return nthOfPerson;
    }

    if (isLeftDirection(nthOfPerson)) {
      return nthOfPerson + 1;
    }

    return nthOfPerson - 1;
  }

  private boolean isLeftDirection(int nthOfPerson) {
    return persons[nthOfPerson] == 1;
  }

  private boolean isNoLine(int nthOfPerson) {
    return persons[nthOfPerson] == 0;
  }
}
