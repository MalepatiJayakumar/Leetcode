package cs3500.klondike.model.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * The BasicKlondike class displays a basic implementation of the
 * Klondike solitaire card game.
 * It implements the KlondikeModel interface, providing the core logic for the game.
 * This class allows players to start and play Klondike solitaire,
 * making moves and tracking game progress.
 */

public class BasicKlondike implements KlondikeModel {
  private boolean gameStarted;
  private Stack<Card> drawPile;
  private List<Stack<Card>> cascadePiles;
  private List<Stack<Card>> foundationPiles;
  private int numRows;
  private int numDrawCards;


  /**
   * Initializes a new instance of the BasicKlondike class.
   */

  public BasicKlondike() {
    gameStarted = false;
    drawPile = new Stack<>();
    cascadePiles = new ArrayList<>();
    foundationPiles = new ArrayList<>();
    numRows = 7;
    numDrawCards = 3;
  }

  /**
   * Retrieves the standard deck of 52 cards used for Klondike.
   *
   * @return A list of cards representing the standard deck.
   */

  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new StandardCard(rank, suit));
      }
    }
    return deck;
  }


  /**
   * Starts a new game of Klondike with the specified parameters.
   *
   * @param deck     The deck of cards to use for the game.
   * @param shuffle  Whether to shuffle the deck before starting the game.
   * @param numPiles The number of cascade piles to use in the game.
   * @param numDraw  The number of draw cards to reveal at a time.
   * @throws IllegalStateException    If the game has already started.
   * @throws IllegalArgumentException If the deck is invalid, or
   *                                  if numPiles or numDraw is non-positive.
   */

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numPiles, int numDraw) {
    if (gameStarted) {
      throw new IllegalStateException("The game has already started.");
    }

    if (deck == null || deck.size() == 0) {
      throw new IllegalArgumentException("Invalid deck.");
    }
    for (Card c : deck) {
      if (c == null) {
        throw new IllegalArgumentException("Card in provided deck was null.");
      }
    }
    if (numPiles <= 0 || numDraw <= 0) {
      throw new IllegalArgumentException("Invalid number of piles or draw count.");
    }

    if ((numPiles * (numPiles + 1)) / 2 > deck.size()) {
      throw new IllegalArgumentException("Bad runs");
    }

    if (!checkRuns()) {
      throw new IllegalArgumentException("Bad runs");
    }
    if (shuffle) {
      Collections.shuffle(deck);
    }


    cascadePiles.clear();
    foundationPiles.clear();

    for (int i = 0; i < numPiles; i++) {
      cascadePiles.add(new Stack<>());
    }

    for (int i = 0; i < 4; i++) {
      foundationPiles.add(new Stack<>());
    }

    int deckIndex = 0;

    for (int j = 0; j < numPiles; j++) {
      for (int k = 0; k < j + 1; k++) {
        if (k == j) {
          deck.get(deckIndex).uncover();
        }
        cascadePiles.get(j).push(deck.get(deckIndex));
        deckIndex++;
      }
    }
    for (int i = deck.size() - 1; i >= deckIndex; i--) {
      if (!deck.isEmpty()) {
        deck.get(i).uncover();
        drawPile.push(deck.get(i));
      }

    }
    gameStarted = true;
  }

  private boolean checkRuns() {
    for (int i = 0; i < 13; i++) {
      Rank[] newArray = Rank.values();
      Suit[] newArray1 = Suit.values();
      boolean check = false;
      if (foundCard(newArray[i] + "" + newArray1[0]) != null) {
        check = true;
      }
      for (int j = 0; j < 4; j++) {
        if (foundCard(newArray[i] + "" + newArray1[0]) != null && !check) {
          return false;
        }
      }
    }
    return true;
  }

  private Card foundCard(String cardName) {
    for (Card card : getDeck()) {
      if (card.toString().equals(cardName)) {
        return card;
      }
    }
    return null;
  }

  /**
   * Moves a pile of cards from one cascade pile to another.
   *
   * @param srcPile  The index of the source cascade pile.
   * @param numCards The number of cards to move.
   * @param destPile The index of the destination cascade pile.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the pile indices are invalid,
   *                                  or if the move is not allowed.
   */

  @Override
  public void movePile(int srcPile, int numCards, int destPile) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (srcPile < 0 || srcPile >= cascadePiles.size() || destPile < 0
            || destPile >= cascadePiles.size() || srcPile == destPile) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    Stack<Card> sourceCascade = cascadePiles.get(srcPile);
    Stack<Card> destCascade = cascadePiles.get(destPile);

    if (sourceCascade.isEmpty()) {
      throw new IllegalArgumentException("Source pile is empty.");
    }

    if (numCards <= 0 || numCards > sourceCascade.size()) {
      throw new IllegalArgumentException("Invalid number of cards to move.");
    }

    List<Card> cardsToMove = new ArrayList<>();
    for (int i = 0; i < numCards; i++) {
      cardsToMove.add(sourceCascade.pop());
    }

    if (!isMoveValid(cardsToMove, destCascade)) {
      throw new IllegalStateException("Invalid move.");
    }

    for (int i = cardsToMove.size() - 1; i >= 0; i--) {
      destCascade.push(cardsToMove.get(i));
    }
  }

  /**
   * Moves the top card from the draw pile to a cascade pile.
   *
   * @param destPile The index of the destination cascade pile.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the pile index is invalid,
   *                                  or if the move is not allowed.
   */

  @Override
  public void moveDraw(int destPile) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (destPile < 0 || destPile >= cascadePiles.size()) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    Stack<Card> destCascade = cascadePiles.get(destPile);

    if (drawPile.isEmpty()) {
      throw new IllegalStateException("Draw pile is empty.");
    }

    Card drawCard = drawPile.peek();

    if (!isMoveValid(drawCard, destCascade)) {
      throw new IllegalStateException("Invalid move.");
    }

    drawPile.pop();
    destCascade.push(drawCard);

  }

  /**
   * Moves the top card from a cascade pile to a foundation pile.
   *
   * @param srcPile        The index of the source cascade pile.
   * @param foundationPile The index of the destination foundation pile.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the pile indices are invalid,
   *                                  or if the move is not allowed.
   */

  @Override
  public void moveToFoundation(int srcPile, int foundationPile) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (srcPile < 0 || srcPile >= cascadePiles.size() || foundationPile < 0
            || foundationPile >= foundationPiles.size()) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    if (cascadePiles.get(srcPile).isEmpty()) {
      throw new IllegalStateException("Source pile is empty.");
    }
    Stack<Card> sourceCascade = cascadePiles.get(srcPile);
    Stack<Card> foundation = foundationPiles.get(foundationPile);

    Card cardToMove = sourceCascade.peek();

    if (!isMoveToFoundationValid(cardToMove, foundation)) {
      throw new IllegalStateException("Invalid move to foundation.");
    }

    foundation.push(cardToMove);
    sourceCascade.pop();
  }

  /**
   * Moves the top card from the draw pile to a foundation pile.
   *
   * @param foundationPile The index of the destination foundation pile.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the foundation pile index is invalid,
   *                                  or if the move is not allowed.
   */

  @Override
  public void moveDrawToFoundation(int foundationPile) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (foundationPile < 0 || foundationPile >= foundationPiles.size()) {
      throw new IllegalArgumentException("Invalid foundation pile index.");
    }

    Stack<Card> foundation = foundationPiles.get(foundationPile);

    if (drawPile.isEmpty()) {
      throw new IllegalStateException("Draw pile is empty.");
    }

    Card drawCard = drawPile.peek();

    if (isMoveToFoundationValid(drawCard, foundation)) {

      foundation.push(drawCard);
      drawPile.pop();

    } else {
      throw new IllegalStateException("Invalid move to foundation.");
    }

  }

  /**
   * Discards the top card from the draw pile.
   *
   * @throws IllegalStateException If the game has not started
   *                               or if the draw pile is empty.
   */

  @Override
  public void discardDraw() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (drawPile.isEmpty() || drawPile == null) {
      throw new IllegalStateException("Draw pile is empty.");
    }

    Card removed = drawPile.pop();
    removed.cover();
    drawPile.add(0, removed);
  }

  /**
   * Gets the number of rows in the game's cascade piles.
   *
   * @return The number of rows in the cascade piles.
   */

  @Override
  public int getNumRows() {
    if (!gameStarted) {
      throw new IllegalStateException("game hasn't started");
    }
    return numRows;
  }

  /**
   * Gets the number of cascade piles in the game.
   *
   * @return The number of cascade piles.
   */

  @Override
  public int getNumPiles() {
    if (!gameStarted) {
      throw new IllegalStateException("game hasn't started");
    }
    return cascadePiles.size();
  }

  /**
   * Gets the number of draw cards to reveal at a time.
   *
   * @return The number of draw cards.
   */

  @Override
  public int getNumDraw() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }
    return numDrawCards;
  }


  /**
   * Checks if the game is over, meaning all foundation piles are complete.
   *
   * @return True if the game is over, false otherwise.
   * @throws IllegalStateException If the game has not started.
   */

  @Override
  public boolean isGameOver() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    return getDrawCards().isEmpty() && drawPile.isEmpty();
  }

  /**
   * Gets the current score of the game, based on completed foundation piles.
   *
   * @return The game score.
   * @throws IllegalStateException If the game has not started.
   */

  @Override
  public int getScore() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    int score = 0;
    for (Stack<Card> foundation : foundationPiles) {
      score += foundation.size();
    }
    return score;
  }

  /**
   * Gets the height (number of cards) of a cascade pile.
   *
   * @param pileNum The index of the cascade pile.
   * @return The height of the specified cascade pile.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the pile index is invalid.
   */

  @Override
  public int getPileHeight(int pileNum) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (pileNum < 0 || pileNum >= cascadePiles.size()) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    return cascadePiles.get(pileNum).size();
  }

  /**
   * Checks if a card in a cascade pile is visible (uncovered).
   *
   * @param pileNum The index of the cascade pile.
   * @param card    The index of the card in the cascade pile.
   * @return True if the card is visible, false otherwise.
   * @throws IllegalStateException    If the game has not started.
   * @throws IllegalArgumentException If the pile or card indices are invalid.
   */

  @Override
  public boolean isCardVisible(int pileNum, int card) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (pileNum < 0 || pileNum >= cascadePiles.size()) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    Stack<Card> cascade = cascadePiles.get(pileNum);

    if (card < 0 || card >= cascade.size()) {
      throw new IllegalArgumentException("Invalid card index.");
    }

    return card == cascade.size() - 1 || cascade.get(card).isUncovered();
  }

  /**
   * Gets the card at a specific position in a cascade pile.
   */
  @Override
  public Card getCardAt(int pileNum, int card) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (pileNum < 0 || pileNum >= cascadePiles.size()) {
      throw new IllegalArgumentException("Invalid pile index.");
    }

    Stack<Card> cascade = cascadePiles.get(pileNum);

    if (card < 0 || card >= cascade.size()) {
      throw new IllegalArgumentException("Invalid card index.");
    }
    if (!cascade.get(card).isUncovered()) {
      throw new IllegalArgumentException("card is not uncovered.");
    }

    return cascade.get(card);
  }

  /**
   * Gets the top card of a foundation pile.
   */

  @Override
  public Card getCardAt(int foundationPile) {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    if (foundationPile < 0 || foundationPile >= foundationPiles.size()) {
      throw new IllegalArgumentException("Invalid foundation pile index.");
    }

    Stack<Card> foundation = foundationPiles.get(foundationPile);

    if (foundation.isEmpty()) {
      return null;
    }
    if (!foundation.peek().isUncovered()) {
      throw new IllegalStateException("card is not uncovered.");
    }

    return foundation.peek();
  }

  /**
   * Gets the visible draw cards (cards from the draw pile)
   * that are currently available.
   *
   * @return A list of visible draw cards.
   * @throws IllegalStateException If the game has not started.
   */

  @Override
  public List<Card> getDrawCards() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    List<Card> visibleDrawCards = new ArrayList<>();
    int numVisibleCards = Math.min(numDrawCards, drawPile.size());
    for (int i = 0; i < numVisibleCards; i++) {
      visibleDrawCards.add(drawPile.get(i));
    }
    visibleDrawCards = Collections.unmodifiableList(visibleDrawCards);
    return visibleDrawCards;
  }

  /**
   * Gets the number of foundation piles in the game.
   *
   * @return The number of foundation piles.
   * @throws IllegalStateException If the game has not started.
   */

  @Override
  public int getNumFoundations() {
    if (!gameStarted) {
      throw new IllegalStateException("Game has not started yet.");
    }

    return foundationPiles.size();
  }


  private boolean isMoveValid(Card topCard, Stack<Card> destCascade) {
    if (destCascade.isEmpty() && topCard.getRank() == Rank.KING || !topCard.isUncovered()) {
      return true;
    }

    if (!destCascade.isEmpty()) {
      Card destTopCard = destCascade.peek();

      return isDescendingByOneRank(topCard, destTopCard)
              && isDifferentColor(topCard, destTopCard) && (destTopCard.isUncovered());
    }
    return false;
  }

  private boolean isMoveValid(List<Card> cardsToMove, Stack<Card> destCascade) {
    Card sourceBottomCard = cardsToMove.get(cardsToMove.size() - 1);
    if (destCascade.isEmpty() && sourceBottomCard.getRank() == Rank.KING) {
      return true;
    }

    if (!destCascade.isEmpty()) {
      Card destTopCard = destCascade.peek();
      if (!isDescendingByOneRank(sourceBottomCard, destTopCard)) {
        return false;
      }

      if (!destTopCard.isUncovered() || !sourceBottomCard.isUncovered()) {
        return false;
      }

      return isDifferentColor(sourceBottomCard, destTopCard);
    }
    return false;
  }


  private boolean isDescendingByOneRank(Card card1, Card card2) {
    Rank rank1 = card1.getRank();
    Rank rank2 = card2.getRank();

    int rank1Value = rank1.ordinal();
    int rank2Value = rank2.ordinal();

    return rank1Value == rank2Value - 1;
  }

  private boolean isDifferentColor(Card card1, Card card2) {
    Suit suit1 = card1.getSuit();
    Suit suit2 = card2.getSuit();
    String color1 = "";
    String color2 = "";


    if (suit1 == Suit.HEARTS || suit1 == Suit.DIAMONDS) {
      color1 = "RED";
    }

    if (suit1 == Suit.SPADES || suit1 == Suit.CLUBS) {
      color1 = "BLACK";
    }

    if (suit2 == Suit.HEARTS || suit2 == Suit.DIAMONDS) {
      color2 = "RED";
    }

    if (suit2 == Suit.SPADES || suit2 == Suit.CLUBS) {
      color2 = "BLACK";
    }

    return !color1.equals(color2);
  }

  private boolean isMoveToFoundationValid(Card cardToMove, Stack<Card> foundation) {
    if (cardToMove == null || foundation == null) {
      return false;
    }

    if (cardToMove.isUncovered()) {

      if (foundation.isEmpty() && cardToMove.getRank().equals(Rank.ACE)) {
        return true;
      }

      if (foundation.isEmpty()) {
        return false;
      }

      Suit foundationSuit = foundation.peek().getSuit();
      Suit cardSuit = cardToMove.getSuit();

      if (foundationSuit == cardSuit) {
        int foundationRankIndex = foundation.peek().getRank().getPointValue();
        int cardRankIndex = cardToMove.getRank().getPointValue();
        return cardRankIndex == foundationRankIndex + 1;
      }
    }
    return false;
  }
}
