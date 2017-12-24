package ladder;

import core.NaturalNumber;
import junit.framework.TestCase;

public class LadderRunnerTest extends TestCase {
  public void testGenerateWhenNoLine() {
    Row[] rows = new Row[3];
    for (int i = 0; i < rows.length; i++) {
      rows[i] = new Row(new NaturalNumber(3));
    }

    String result = LadderRunner.generate(rows, Position.create(1, 1));
    assertEquals("0* 0 0 \n0 0 0 \n0 0 0 \n", result);
  }

  public void testGenerateWhenLine() {
    Row[] rows = new Row[3];
    for (int i = 0; i < rows.length; i++) {
      rows[i] = new Row(new NaturalNumber(3));
    }
    rows[0].drawLine(new NaturalNumber(1));
    String result = LadderRunner.generate(rows, Position.create(1, 1));
    assertEquals("1* -1 0 \n0 0 0 \n0 0 0 \n", result);
  }
}
