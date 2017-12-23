package ladder;

public class Ladder {

  int[] row;

  public Ladder(int noOfPerson) {
    row = new int[noOfPerson];
  }

  public void drawLine(int startPosition) {
    row[startPosition] = 1;
    row[startPosition + 1] = 1;
  }

  public int run(int nthOfPerson) {
    if (row[nthOfPerson] == 0) {
      return nthOfPerson;
    }

    if (nthOfPerson - 1 >= 0) {
      int leftValue = row[nthOfPerson - 1];
      if (leftValue == 1) {
        return nthOfPerson - 1;
      }
    }

//    int rightValue = row[nthOfPerson + 1];
//    if (rightValue == 1) {
//      return nthOfPerson + 1;
//    }
    return nthOfPerson + 1;
  }
}
