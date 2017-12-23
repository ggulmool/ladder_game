package ladder;

public class Ladder {

  int[][] rows;

  public Ladder(int countOfRow, int noOfPerson) {
    rows = new int[countOfRow][noOfPerson];
  }

  public void drawLine(int noOfRow, int startPosition) {
    rows[noOfRow][startPosition] = 1;
    rows[noOfRow][startPosition + 1] = 1;
  }

  public int run(int nthOfPerson) {
    for (int i = 0; i < rows.length; i++) {
      int[] row = rows[i];
      if (row[nthOfPerson] == 0) {
        continue;
      }

      if (nthOfPerson - 1 >= 0) {
        int leftValue = row[nthOfPerson - 1];
        if (leftValue == 1) {
          nthOfPerson -= 1;
          continue;
        }
      }

      nthOfPerson += 1;
    }
    return nthOfPerson;
  }
}
