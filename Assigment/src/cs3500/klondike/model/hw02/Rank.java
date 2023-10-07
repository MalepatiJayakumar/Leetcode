package cs3500.klondike.model.hw02;

/**
 * The {@code Rank} enum represents the ranks of playing cards in a standard deck.
 * Each rank has a symbolic representation (e.g., "A" for Ace, "2" for Two) and a corresponding
 * point value used in the game.
 */

public enum Rank {
  ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4),
  FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
  NINE("9", 9), TEN("10", 10), JACK("J", 11), QUEEN("Q", 12),
  KING("K", 13);

  private final String symbol;
  private final int pointValue;

  private Rank(String symbol, int pointValue) {
    this.symbol = symbol;
    this.pointValue = pointValue;
  }

  @Override
  public String toString() {
    return symbol;
  }

  public int getPointValue() {
    return pointValue;
  }
}
