package ladder;

import core.NaturalNumber;

class LadderGame {

  enum LadderType {
    MANUAL, RANDOM;
  }

  private LadderCreator ladderCreator;

  LadderGame(NaturalNumber height, NaturalNumber noOfPerson) {
    ladderCreator = new RandomLadderCreator(height, noOfPerson);
  }

  LadderGame(NaturalNumber height, NaturalNumber noOfPerson, LadderType ladderType) {
    if (ladderType == LadderType.MANUAL) {
      ladderCreator = new ManualLadderCreator(height, noOfPerson);
    } else {
      ladderCreator = new RandomLadderCreator(height, noOfPerson);
    }
  }

  void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    ladderCreator.drawLine(height, startPosition);
  }

  Marker run(Marker nthOfPerson) {
    LadderRunner runner = new LadderRunner(ladderCreator.getLadder());
    return runner.run(nthOfPerson);
  }
}
