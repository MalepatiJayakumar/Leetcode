package cs3500.klondike.model.hw02;

/**
 * The {@code StandardCard} class represents a standard playing card with a rank and a suit.
 * It implements the {@link Card} interface and provides methods to access the card's rank, suit,
 * point value, and whether it is uncovered (visible) or covered (hidden).
 */

public class StandardCard implements Card {
  private final Rank rank;
  private final Suit suit;
  private boolean uncovered;

  /**
   * Creates a new standard playing card with the given rank and suit.
   * By default, the card is considered covered (hidden).
   *
   * @param rank The rank of the card.
   * @param suit The suit of the card.
   */

  public StandardCard(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    this.uncovered = false;
  }

  /**
   * Returns the rank of the card.
   *
   * @return The rank of the card as a string.
   */

  @Override
  public Rank getRank() {
    return rank;
  }

  /**
   * Returns the suit of the card.
   *
   * @return The suit of the card as a string.
   */

  @Override
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns the point value of the card.
   * Point values are not defined in this class and always return 0.
   *
   * @return The point value of the card.
   */

  @Override
  public int getPointValue() {
    return 0;
  }

  /**
   * Returns a string representation of the card, including its rank and suit.
   *
   * @return A string representing the card, e.g., "ACE of HEARTS".
   */

  @Override
  public String toString() {
    return rank + "" + suit;
  }

  /**
   * Checks whether the card is uncovered (visible).
   *
   * @return {@code true} if the card is uncovered, {@code false} if it is covered (hidden).
   */

  public boolean isUncovered() {
    return uncovered;
  }

  /**
   * Uncovers the card, making it visible.
   */

  public void uncover() {
    uncovered = true;
  }

  /**
   * Covers the card, making it hidden.
   */

  public void cover() {
    uncovered = false;
  }
}
