package ladder.creator;

import core.NaturalNumber;
import ladder.Row;

public class ManualLadderCreator implements LadderCreator {

  private Row[] rows;

  public ManualLadderCreator(NaturalNumber height, NaturalNumber noOfPerson) {
    rows = new Row[height.getNumber()];

    for (int i = 0; i < height.getNumber(); i++) {
      rows[i] = new Row(noOfPerson);
    }
  }

  @Override
  public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    if (isOverHeight(height)) {
      throw new IllegalArgumentException(
          String.format("사다리 최대 높이를 넘어섰습니다.현재 값은 : %d", height.getNumber()));
    }

    rows[height.toArrayIndex()].drawLine(startPosition);
  }

  @Override
  public Row[] getLadder() {
    return this.rows;
  }

  private boolean isOverHeight(NaturalNumber height) {
    return height.toArrayIndex() > rows.length - 1;
  }
}
