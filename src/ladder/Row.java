package ladder;

import core.NaturalNumber;

class Row {
  private Node[] nodes;

  public Row(NaturalNumber noOfPerson) {
    nodes = new Node[noOfPerson.getNumber()];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = Node.createCenterNode();
    }
  }

  void drawLine(NaturalNumber startPosition) {
    int startIndex = startPosition.toArrayIndex();
    if (isOverNoOfPersons(startIndex)) {
      throw new IllegalArgumentException(String.format("시작점 Index값은 %d 미만이어야 합니다. 현재 값 : %d", nodes.length - 1, startIndex));
    }

    if (nodes[startIndex].isLeftDirection()) {
      throw new IllegalArgumentException("선을 그을 수 없는 위치입니다.");
    }

    nodes[startIndex].changeRight();
    nodes[startIndex + 1].changeLeft();
  }

  private boolean isOverNoOfPersons(int startIndex) {
    // 사람수 5일경우 선 시작 위치는 4이상이 될 수 없다. 즉 3까지 허용
    return startIndex >= nodes.length - 1;
  }

  Marker move(Marker marker) {
    return nodes[marker.toArrayIndex()].move(marker);
  }

  public Node[] getNodes() {
    return this.nodes;
  }
}
