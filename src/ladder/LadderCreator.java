package ladder;

import core.NaturalNumber;

public interface LadderCreator {

  void drawLine(NaturalNumber height, NaturalNumber startPosition);

  Row[] getLadder();
}
