package ladder;

import java.util.Objects;

public class Node {

  enum Direction {
    LEFT(-1), CENTER(0), RIGHT(1);
    private int symbol;

    private Direction(int symbol) {
      this.symbol = symbol;
    }
  }

  private Direction direction;

  private Node(Direction direction) {
    this.direction = direction;
  }

  Direction getDirection() {
    return direction;
  }

  void changeRight() {
    this.direction = Direction.RIGHT;
  }

  void changeLeft() {
    this.direction = Direction.LEFT;
  }

  boolean isRightDirection() {
    return direction == Direction.RIGHT;
  }

  boolean isLeftDirection() {
    return direction == Direction.LEFT;
  }

  void appendSymbol(StringBuilder builder) {
    builder.append(direction.symbol);
  }

  Marker move(Marker marker) {
    if (isRightDirection()) {
      return marker.moveRight();
    }

    if (isLeftDirection()) {
      return marker.moveLeft();
    }

    return marker;
  }

  static Node createCenterNode() {
    return new Node(Direction.CENTER);
  }

  static Node createRightNode() {
    return new Node(Direction.RIGHT);
  }

  static Node createLeftNode() {
    return new Node(Direction.LEFT);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return direction == node.direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(direction);
  }
}
