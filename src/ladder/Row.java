package ladder;

public class Row {

  int[] persons;

  public Row(int noOfPerson) {
    persons = new int[noOfPerson];
  }

  void drawLine(int startPosition) {
    persons[startPosition] = 1;
    persons[startPosition + 1] = 1;
  }

  int moveRow(int nthOfPerson) {
    if (isNoLine(persons[nthOfPerson])) {
      return nthOfPerson;
    }

    if (isNotLeftEnd(nthOfPerson) && canLeft(persons[nthOfPerson - 1])) {
      return nthOfPerson - 1;
    }

    return nthOfPerson + 1;
  }

  private boolean canLeft(int nthOfPerson) {
    return nthOfPerson == 1;
  }

  private boolean isNotLeftEnd(int nthOfPerson) {
    return nthOfPerson - 1 >= 0;
  }

  private boolean isNoLine(int nthOfPerson) {
    return nthOfPerson == 0;
  }
}
