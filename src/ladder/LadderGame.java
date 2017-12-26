package ladder;

import core.NaturalNumber;
import ladder.creator.LadderCreator;

class LadderGame {

  private LadderCreator ladderCreator;

  public LadderGame(LadderCreator ladderCreator) {
    this.ladderCreator = ladderCreator;
  }

  void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    ladderCreator.drawLine(height, startPosition);
  }

  Marker run(Marker nthOfPerson) {
    LadderRunner runner = new LadderRunner(ladderCreator.getLadder());
    return runner.run(nthOfPerson);
  }
}
