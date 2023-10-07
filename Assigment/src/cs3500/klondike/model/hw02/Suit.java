package cs3500.klondike.model.hw02;

/**
 * The {@code Suit} enum represents the suits of standard playing cards.
 * Each suit is associated with a unique symbol, which can be used to display the suit symbolically.
 */

public enum Suit {
  HEARTS("♡"), DIAMONDS("♢"), CLUBS("♣"), SPADES("♠");

  private final String symbol;

  private Suit(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Returns the symbol representing the suit.
   *
   * @return The suit's symbol as a string.
   */

  @Override
  public String toString() {
    return symbol;
  }
}
