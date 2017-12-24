package ladder;

import junit.framework.TestCase;

import static ladder.Node.Direction.*;

public class NodeTest extends TestCase {

  public void testCreateCenter() {
    Node node = Node.createCenterNode();
    assertEquals(CENTER, node.getDirection());
  }

  public void testChangeRight() {
    Node node = Node.createCenterNode();
    node.changeRight();
    assertEquals(Node.createRightNode(), node);
  }

  public void testChangeLeft() {
    Node node = Node.createCenterNode();
    node.changeLeft();
    assertEquals(Node.createLeftNode(), node);
  }

  public void testMoveRight() {
    Node node = Node.createRightNode();
    Marker marker = node.move(new Marker(3));
    assertEquals(new Marker(4), marker);
  }

  public void testMoveLeft() {
    Node node = Node.createLeftNode();
    Marker marker = node.move(new Marker(3));
    assertEquals(new Marker(2), marker);
  }

  public void testMoveCenter() {
    Node node = Node.createCenterNode();
    Marker marker = node.move(new Marker(3));
    assertEquals(new Marker(3), marker);
  }

  public void testSymbol() {
    Node node = Node.createCenterNode();
    StringBuilder sb = new StringBuilder();
    node.appendSymbol(sb);
    assertEquals("0", sb.toString());
//    node = Node.createLeftNode();
//    assertEquals(-1, node.getSymbol());
//    node = Node.createRightNode();
//    assertEquals(1, node.getSymbol());
  }
}
