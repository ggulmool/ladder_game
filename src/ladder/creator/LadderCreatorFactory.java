package ladder.creator;

import core.NaturalNumber;

public class LadderCreatorFactory {

  public enum LadderType {
    MANUAL, RANDOM
  }

  private LadderCreatorFactory() {
  }

  public static LadderCreator newLadderCreator(NaturalNumber height, NaturalNumber noOfPerson,
      LadderType ladderType) {
    if (ladderType == LadderType.MANUAL) {
      return new ManualLadderCreator(height, noOfPerson);
    }
    return new RandomLadderCreator(height, noOfPerson);
  }
}
