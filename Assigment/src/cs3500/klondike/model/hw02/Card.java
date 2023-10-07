package cs3500.klondike.model.hw02;

/**
 * This (essentially empty) interface marks the idea of cards.  You will need to
 * implement this interface in order to use your model.
 *
 * <p>The only behavior guaranteed by this class is its {@link Card#toString()} method,
 * which will render the card as specified in the assignment.
 *
 * <p>In particular, you <i>do not</i> know what implementation of this interface is
 * used by the Examplar wheats and chaffs, so your tests must be defined sufficiently
 * broadly that you do not rely on any particular constructors or methods of cards.
 */
public interface Card {

  /**
   * Renders a card with its value followed by its suit as one of
   * the following symbols (♣, ♠, ♡, ♢).
   * For example, the 3 of Hearts is rendered as {@code "3♡"}.
   *
   * @return the formatted card
   */

  final Rank rank = null;
  final Suit suit = null;
  final boolean uncovered = false;

  Rank getRank();

  /**
   * Get the suit of the card (e.g., Hearts, Diamonds, Clubs, Spades).
   *
   * @return The suit of the card.
   */
  Suit getSuit();

  /**
   * Get the point value of the card in a card game.
   *
   * @return The point value of the card.
   */
  int getPointValue();

  /**
   * Get a string representation of the card (e.g., "Ace of Spades").
   *
   * @return A string representation of the card.
   */
  String toString();

  boolean isUncovered();

  void uncover();

  void cover();

}
