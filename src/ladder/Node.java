package ladder;

import java.util.Objects;

public class Node {

  enum Direction {
    LEFT, CENTER, RIGHT
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

  Marker move(Marker marker) {
    if (direction == Direction.RIGHT) {
      return marker.moveRight();
    }

    if (direction == Direction.LEFT) {
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
