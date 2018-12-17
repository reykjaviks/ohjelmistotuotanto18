package ohtu.kivipaperisakset.logic;

import ohtu.kivipaperisakset.util.MostPopularMove;
import ohtu.kivipaperisakset.util.Move;

public class MuistavaTekoaly implements AI {
  private String[] memory;
  private int usedMemory;

  public MuistavaTekoaly(int memorySize) {
    memory = new String[memorySize];
    usedMemory = 0;
  }
  
  public void setMove(String move) {
    if (memoryIsFull()) {
      releaseMemory();
    }
    addMoveToMemory(move);
  }

  public String calculateNextMove() {
    if (noPreviousMoves()) {
      return "k";
    }

    Move mostPopularMove = getMostPopularMove(calculatePreviousMoves());
    switch (mostPopularMove.getMoveName()) {
      case KIVI: return "p";
      case PAPERI: return "s";
      default: return "k";
    }
  }

  private void releaseMemory() {
    for(int i = 1; i < memory.length; i++) {
      memory[i-1] = memory[i];
    }
    usedMemory--;
  }

  private boolean memoryIsFull() {
    return usedMemory == memory.length;
  }

  private boolean noPreviousMoves() {
    return usedMemory == 0 || usedMemory == 1;
  }

  private void addMoveToMemory(String move) {
    memory[usedMemory] = move;
    usedMemory++;
  }

  private int[] calculatePreviousMoves() {
    int numOfRocks = 0;
    int numOfPapers = 0;
    int numOfScissors = 0;

    for (String move : memory) {
      switch (move) {
        case "k": numOfRocks++;
        case "p": numOfPapers++;
        default: numOfScissors++;
      }
    }
    return new int[]{numOfRocks, numOfPapers, numOfScissors};
  }

  private Move getMostPopularMove(int[] previousMoves) {
    int k = previousMoves[0];
    int p = previousMoves[1];
    int s = previousMoves[2];
    return MostPopularMove.calculate(k, p, s);
  }

}