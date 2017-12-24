package ladder;

import java.util.Random;
import junit.framework.TestCase;

public class RandomLadderCreatorTest extends TestCase {

  public void testGenerateStartPositions() {
    for (int i = 0; i < 10; i++) {
      System.out.println(randInt(1, 20));
    }

    // 4 * 5 => 20
    // 0 0 0 0 0
    // 0 0 0 0 0
    // 0 0 0 0 0
    // 0 0 0 0 0

    /*
     * 5의 배수가 되는 지점 x
     * 이미 생성되어 있는 지점에 선을 그을 때 x
     * 사다리 크기에 따라 임의로 생성되는 선의 수를 결정
     *
    */
  }

  public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
}
