package ladder;

import core.NaturalNumber;
import java.util.List;
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

  public void testRandomNumberEquals() {
    assertTrue(new RandomNaturalNumber(1).equals(new NaturalNumber(1)));
    assertTrue(new NaturalNumber(1).equals(new RandomNaturalNumber(1)));
  }

  public void testCheckedNaturalNumbers() {
    RandomNaturalNumber randomNumber = new RandomNaturalNumber(2);
    List<NaturalNumber> naturalNumbers = randomNumber.checkedNaturalNumbers(new NaturalNumber(3));
    assertTrue(naturalNumbers.size() == 3);
  }

  public void testCheckNaturalNumbersWheFirst() {
    RandomNaturalNumber randomNumber = new RandomNaturalNumber(4);
    List<NaturalNumber> naturalNumbers = randomNumber.checkedNaturalNumbers(new NaturalNumber(3));
    assertTrue(naturalNumbers.size() == 2);
  }
}