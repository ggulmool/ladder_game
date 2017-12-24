package ladder;

class Row {

  private enum Direction {
    LEFT(-1),
    CENTER(0),
    RIGHT(1);

    private int no;

    private Direction(int no) {
      this.no = no;
    }

    int getNo() {
      return no;
    }
  }

  private int[] persons;

  public Row(NaturalNumber noOfPerson) {
    persons = new int[noOfPerson.getNumber()];
  }

  void drawLine(NaturalNumber startPosition) {
    int startIndex = startPosition.toArrayIndex();
    if (startIndex >= persons.length - 1) {
      throw new IllegalArgumentException(String.format("시작점은 %d 미만이어야 합니다. 현재 값 : %d", persons.length - 1, startIndex));
    }

    if (persons[startIndex] == -1) {
      throw new IllegalArgumentException("선을 그을 수 없는 위치 입니다.");
    }

    persons[startIndex] = Direction.RIGHT.getNo();
    persons[startIndex + 1] = Direction.LEFT.getNo();
  }

  int move(int startMarker) {
    if (startMarker < 0) {
      throw new IllegalArgumentException("사다리의 시작위치는 0 이상이어야 합니다.");
    }

    if (isNoLine(startMarker)) {
      return startMarker;
    }

    if (isRightDirection(startMarker)) {
      return startMarker + 1;
    }

    return startMarker - 1;
  }

  private boolean isRightDirection(int nthOfPerson) {
    return persons[nthOfPerson] == Direction.RIGHT.getNo();
  }

  private boolean isNoLine(int nthOfPerson) {
    return persons[nthOfPerson] == Direction.CENTER.getNo();
  }
}
