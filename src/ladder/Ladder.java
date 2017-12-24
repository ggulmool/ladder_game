package ladder;

import core.NaturalNumber;

class Ladder {

  private Row[] rows;

  public Ladder(NaturalNumber height, NaturalNumber noOfPerson) {
    rows = new Row[height.getNumber()];

    for (int i = 0; i < height.getNumber(); i++) {
      rows[i] = new Row(noOfPerson);
    }
  }

  void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    if (isOverHeight(height)) {
      throw new IllegalArgumentException(String.format("사다리 최대 높이를 넘어섰습니다.현재 값은 : %d", height.getNumber()));
    }

    rows[height.toArrayIndex()].drawLine(startPosition);
  }

  private boolean isOverHeight(NaturalNumber height) {
    return height.toArrayIndex() > rows.length - 1;
  }

  Marker run(Marker nthOfPerson) {
    for (int i = 0; i < rows.length; i++) {
      Row row = rows[i];
      nthOfPerson = row.move(nthOfPerson);
      String result = generate(rows, Position.createFromArrayIndex(i, nthOfPerson.toArrayIndex()));
      System.out.println(result);
    }
    return nthOfPerson;
  }

  static String generate(Row[] rows, Position position) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rows.length; i++) {
      Row row = rows[i];
      row.generateRow(sb, i, position);
    }

    return sb.toString();
  }
}
