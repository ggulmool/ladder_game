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

    int i = 0;
    do {
      RandomNaturalNumber randomPosition = randInt(1, totalPositions.getNumber());
      if (ladderSize.isMultipleOfPerson(randomPosition)) {
        continue;
      }

      if (randomPositions.contains(randomPosition)) {
        continue;
      }

      if (randomPositions.contains(new RandomNaturalNumber(randomPosition.getNumber() +  1))) {
        continue;
      }

      if (randomPosition.equals(new NaturalNumber(1))) {
        randomPositions.add(randomPosition);
        System.out.println(String.format("random position : %s", randomPosition));
        i++;
      } else {
        if (randomPositions.contains(new RandomNaturalNumber(randomPosition.toArrayIndex()))) {
          continue;
        }

        randomPositions.add(randomPosition);
        System.out.println(String.format("random position : %s", randomPosition));
        i++;
      }
    } while (i < countOfLine);

    return randomPositions;
  }

  List<Position> toPositions(List<RandomNaturalNumber> randomNumbers) {
    List<Position> positions = new ArrayList<>(randomNumbers.size());
    for (RandomNaturalNumber randomNumber : randomNumbers) {
      positions.add(ladderSize.getPosition(randomNumber));
    }
    return positions;
  }

  static RandomNaturalNumber randInt(int min, int max) {
    Random rand = new Random();
    return new RandomNaturalNumber(rand.nextInt((max - min) + 1) + min);
  }
}
