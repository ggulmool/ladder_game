package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class RandomNaturalNumberTest extends TestCase {

  public void testGetPositionOfPerson() {
    RandomNaturalNumber number = new RandomNaturalNumber(4);
    int actual = number.getPositionOfPerson(3);
    // 1 2 3
    // 4 5 6 => 높이는 2, 사람의 위치는 1
    assertEquals(1, actual);
  }

  public void testGetPositionOfHeight() {
    RandomNaturalNumber number = new RandomNaturalNumber(4);
    int actual = number.getPositionOfHeight(3);
    assertEquals(2, actual);
  }

  public void testIsMultipleOfPerson() {
    RandomNaturalNumber randomNumber = new RandomNaturalNumber(8);
    assertTrue(randomNumber.isMultipleOfPerson(4));
    randomNumber = new RandomNaturalNumber(5);
    assertFalse(randomNumber.isMultipleOfPerson(3));
  }

  public void testEquals() {
    assertTrue(new RandomNaturalNumber(1).equals(new NaturalNumber(1)));
    assertTrue(new NaturalNumber(1).equals(new RandomNaturalNumber(1)));
  }
}