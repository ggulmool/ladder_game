package ladder;

public class Ladder {

  private int[] row;

  public Ladder(int noOfPerson) {
    row = new int[noOfPerson];
  }

  public void drawLine(int startPosition) {
    row[startPosition] = 1;
    row[startPosition + 1] = 1;
  }

  public int run(int nthOfPerson) {
    // 1 1 0
    if (nthOfPerson - 1 <= 0 && row[nthOfPerson - 1] == 1) {
      return nthOfPerson + 1;
    }

    if (row[nthOfPerson - 1] == 1) {
      if (row[nthOfPerson - 2] == 1) {
        return nthOfPerson - 1;
      }

      if (row[nthOfPerson] == 1) {
        return nthOfPerson + 1;
      }
    }

    return nthOfPerson;
  }
}
