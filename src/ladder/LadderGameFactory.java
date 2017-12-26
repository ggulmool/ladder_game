package ladder;

import core.NaturalNumber;
import ladder.creator.ManualLadderCreator;
import ladder.creator.RandomLadderCreator;

public class LadderGameFactory {

  private LadderGameFactory() {
  }

  static LadderGame randomLadderGame(NaturalNumber height, NaturalNumber noOfPerson) {
    RandomLadderCreator ladderCreator = new RandomLadderCreator(height, noOfPerson);
    return new LadderGame(ladderCreator);
  }

  static LadderGame manualLadderGame(NaturalNumber height, NaturalNumber noOfPerson) {
    ManualLadderCreator ladderCreator = new ManualLadderCreator(height, noOfPerson);
    return new LadderGame(ladderCreator);
  }
}
