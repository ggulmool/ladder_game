package ladder;

class Ladder {

  private Row[] rows;

  public Ladder(int height, int noOfPerson) {
    if (height < 1) {
      throw new IllegalArgumentException(String.format("사다리 높이는 1 이상이어야 합니다. 현재 값은 : %d", height));
    }

    rows = new Row[height];

    for (int i = 0; i < height; i++) {
      rows[i] = new Row(noOfPerson);
    }
  }

  void drawLine(int height, int startPosition) {
    if (height < 0) {
      throw new IllegalArgumentException(String.format("사다리 높이는 0 이상이어야 합니다. 현재 값은 : %d", height));
    }

    if (height > rows.length - 1) {
      throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘어섰습니다.현재 값은 : %d", height));
    }

    rows[height].drawLine(startPosition);
  }

  int run(int nthOfPerson) {
    for (int i = 0; i < rows.length; i++) {
      nthOfPerson = rows[i].move(nthOfPerson);
    }

    return nthOfPerson;
  }
}
