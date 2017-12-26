package ladder;

import core.NaturalNumber;
import ladder.creator.LadderCreator;
import ladder.creator.LadderCreatorFactory;
import ladder.creator.LadderCreatorFactory.LadderType;

class LadderGame {

  private LadderCreator ladderCreator;

  LadderGame(NaturalNumber height, NaturalNumber noOfPerson, LadderType ladderType) {
    ladderCreator = LadderCreatorFactory.newLadderCreator(height, noOfPerson, ladderType);
  }

  void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    ladderCreator.drawLine(height, startPosition);
  }

  Marker run(Marker nthOfPerson) {
    LadderRunner runner = new LadderRunner(ladderCreator.getLadder());
    return runner.run(nthOfPerson);
  }
}
