package ladder;

class LadderRunner {

  private Row[] rows;

  LadderRunner(Row[] rows) {
    this.rows = rows;
  }

  Marker run(Marker nthOfPerson) {
    for (int i = 0; i < rows.length; i++) {
      Row row = rows[i];
      System.out.println("Before : ");
      System.out.println(generate(rows, Position.createFromArrayIndex(i, nthOfPerson.toArrayIndex())));
      nthOfPerson = row.move(nthOfPerson);
      System.out.println("After : ");
      System.out.println(generate(rows, Position.createFromArrayIndex(i, nthOfPerson.toArrayIndex())));
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
