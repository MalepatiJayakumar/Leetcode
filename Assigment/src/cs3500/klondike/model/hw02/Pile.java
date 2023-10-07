package cs3500.klondike.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * The Pile class represents a pile of cards in the Klondike solitaire card game.
 * It is used to store and manage a collection of cards within a pile, such as a cascade pile
 * or a foundation pile.
 */

public class Pile {
  private List<Card> cards = new ArrayList<>();

  /**
   * Adds a card to the pile.
   */

  public void addCard(Card drawnCard) {
    cards.add(drawnCard);
  }
}

