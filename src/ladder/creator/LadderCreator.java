package ladder.creator;

import core.NaturalNumber;
import ladder.Row;

public interface LadderCreator {

  void drawLine(NaturalNumber height, NaturalNumber startPosition);

  Row[] getLadder();
}
