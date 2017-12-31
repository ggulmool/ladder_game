package ladder.creator;

import core.NaturalNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.LadderSize;
import ladder.Position;
import ladder.RandomNaturalNumber;
import ladder.Row;

public class RandomLadderCreator implements LadderCreator {

  private static final double DEFAULT_LINE_RATIO = 0.3;
  private LadderCreator ladderCreator;
  private LadderSize ladderSize;

  public RandomLadderCreator(LadderCreator ladderCreator) {
    this.ladderCreator = ladderCreator;
    this.ladderSize = ladderCreator.getLadderSize();
    List<Position> startPositions = generateStartPositions();
    for (Position position : startPositions) {
      ladderCreator.drawLine(position.getHeight(), position.getNthOfPerson());
    }
  }

  @Override
  public void drawLine(NaturalNumber height, NaturalNumber startPosition) {
    throw new UnsupportedOperationException("RandomLadderCreator에서는 drawLine 메서드를 호출할 수 없습니다.");
  }

  @Override
  public Row[] getLadder() {
    return this.ladderCreator.getLadder();
  }

  @Override
  public LadderSize getLadderSize() {
    return this.ladderSize;
  }

  List<Position> generateStartPositions() {
    List<RandomNaturalNumber> numbers = generateRandomPositions();
    return toPositions(numbers);
  }

  List<RandomNaturalNumber> generateRandomPositions() {
    NaturalNumber totalPositions = ladderSize.getTotalPosition();
    int countOfLine = ladderSize.getCountOfLine(DEFAULT_LINE_RATIO);
    List<RandomNaturalNumber> randomPositions = new ArrayList<>();

    do {
      RandomNaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
      if (ladderSize.isMultipleOfPerson(randomPosition)) {
        continue;
      }

      // 아래 로직을 Collection비교를 통한 방법으로 리팩토링
      List<NaturalNumber> checkedNaturalNumbers = randomPosition.checkedNaturalNumbers(ladderSize.getNoOfPerson());
      checkedNaturalNumbers.retainAll(randomPositions);

      // 체크넘버에 포함되어 있지 않으면 추가 (retainAll은 교집합 추출)
      if (checkedNaturalNumbers.isEmpty()) {
        randomPositions.add(randomPosition);
        System.out.println(String.format("random position : %s", randomPosition));
      }

//      if (randomPositions.contains(randomPosition)) {
//        continue;
//      }
//
//      if (randomPositions.contains(new RandomNaturalNumber(randomPosition.getNumber() +  1))) {
//        continue;
//      }
//
//      if (randomPosition.isFirst()) {
//        randomPositions.add(randomPosition);
//        System.out.println(String.format("random position : %s", randomPosition));
//      } else {
//        if (randomPositions.contains(new RandomNaturalNumber(randomPosition.toArrayIndex()))) {
//          continue;
//        }
//
//        randomPositions.add(randomPosition);
//        System.out.println(String.format("random position : %s", randomPosition));
//      }
    } while (randomPositions.size() < countOfLine);

    return randomPositions;
  }

  List<Position> toPositions(List<RandomNaturalNumber> randomNumbers) {
    List<Position> positions = new ArrayList<>(randomNumbers.size());
    for (RandomNaturalNumber randomNumber : randomNumbers) {
      positions.add(ladderSize.getPosition(randomNumber));
      //System.out.println("ladderSize.getPosition(randomNumber) = " + ladderSize.getPosition(randomNumber));
    }
    return positions;
  }

  static RandomNaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new RandomNaturalNumber(rand.nextInt((max - min) + 1) + min);
  }
}
