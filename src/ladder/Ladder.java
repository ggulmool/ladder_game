package ladder;

class Ladder {

  private Row[] rows;

  public Ladder(int countOfRow, int noOfPerson) {
    rows = new Row[countOfRow];

    for (int i = 0; i < countOfRow; i++) {
      rows[i] = new Row(noOfPerson);
    }
  }

  void drawLine(int noOfRow, int startPosition) {
    rows[noOfRow].drawLine(startPosition);
  }

  int run(int nthOfPerson) {
    for (int i = 0; i < rows.length; i++) {
      nthOfPerson = rows[i].move(nthOfPerson);
    }

    return nthOfPerson;
  }
}
