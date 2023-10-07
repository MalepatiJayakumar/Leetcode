

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cs3500.klondike.model.hw02.BasicKlondike;
import cs3500.klondike.model.hw02.Card;
import cs3500.klondike.model.hw02.KlondikeModel;

/**
 * Determines the color of a card's suit based on its Unicode character representation.
 **/

public class ExamplarModelTests {
  private int colorSuit(char suit) {
    switch (suit) {
      case '♡':
      case '♢':
        return 1;
      case '♣':
      case '♠':
        return 2;
      default:
        return 0;
    }
  }

  private int cardVal(char value) {
    switch (value) {
      case 'A':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
      case 'J':
        return 10;
      case 'Q':
        return 11;
      case 'K':
        return 12;
      default:
        return 0;
    }
  }

  private KlondikeModel model = new BasicKlondike();


  @Test
  public void testCardReceived() {
    List<Card> myPersonalDeck = new ArrayList<>();

    addCardToDeck(myPersonalDeck, "3♡");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "A♠");
    model.startGame(myPersonalDeck, false, 2, 1);
    model.movePile(1, 1, 0);
    assertEquals(model.getPileHeight(0), 2);
  }

  private void addCardToDeck(List<Card> personalDeck, String cardName) {
    personalDeck.add(foundCard(cardName));
  }

  private Card foundCard(String cardName) {
    List<Card> initialDeck = model.getDeck();
    for (Card card : initialDeck) {
      if (card.toString().equals(cardName)) {
        return card;
      }
    }
    return null;
  }

  @Test
  public void testMoveCardToFoundation() {
    List<Card> initialDeck = model.getDeck();
    model.startGame(initialDeck, false, 4, 2);
    for (int i = 0; i < 4; i++) {
      Card newCard = model.getCardAt(i, model.getPileHeight(i) - 1);
      if (!aceCard(newCard)) {
        final int newCardNum = i;
        assertThrows(IllegalStateException.class, () -> model.moveToFoundation(newCardNum, 0));
      }
    }
  }

  @Test
  public void testMoveToWrongPile() {
    List<Card> initialDeck = model.getDeck();
    model.startGame(initialDeck, false, 4, 1);
    List<Card> card = model.getDrawCards();
    for (int i = 0; i < 4; i++) {
      Card newCard = model.getCardAt(i, model.getPileHeight(i) - 1);
      if (!moveToPile(card.get(0), newCard)) {
        final int newCardNum = i;
        assertThrows(IllegalStateException.class, () -> model.moveDraw(newCardNum));
      }
    }
  }


  private void testReset() {
    model = new BasicKlondike();
  }

  private boolean aceCard(Card card) {
    return card.toString().startsWith("A");
  }

  private boolean moveToPile(Card card, Card newCard) {
    int cardNum = cardVal(card.toString().charAt(0));
    int cardColor = colorSuit(card.toString().charAt(1));

    int pileValNum = cardVal(newCard.toString().charAt(0));
    int pileColor = colorSuit(newCard.toString().charAt(0));

    return (pileValNum - cardNum == 1 && cardColor != pileColor);
  }


  @Test
  public void testMoveDrawToAFoundationPile() {
    List<Card> initialDeck = model.getDeck();
    model.startGame(initialDeck, false, 4, 2);
    for (Card newCard : model.getDrawCards()) {
      if (!aceCard(newCard)) {
        assertThrows(IllegalStateException.class, () -> model.moveDrawToFoundation(0));
      } else {
        model.discardDraw();
      }
    }
  }

  @Test
  public void moveCardsToEmptyPile() {
    List<Card> myPersonalDeck = new ArrayList<>();

    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "3♡");
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "A♠");

    model.startGame(myPersonalDeck, false, 2, 1);
    model.movePile(0, 1, 1);
    assertThrows(IllegalStateException.class, () -> model.movePile(1, 2, 0));
  }

  @Test
  public void testMoveFoundation() {
    List<Card> myPersonalDeck = new ArrayList<>();

    addCardToDeck(myPersonalDeck, "A♡");//open
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "3♡");
    addCardToDeck(myPersonalDeck, "A♠");//open
    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "2♡");//open

    model.startGame(myPersonalDeck, false, 3, 1);
    model.moveToFoundation(0, 0);
    model.moveToFoundation(2, 0);

    Assert.assertEquals(model.getScore(), 2);
  }

  @Test
  public void testGameEndsAfterDrawingAllCards() {
    List<Card> myPersonalDeck = new ArrayList<>();
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "A♣");
    addCardToDeck(myPersonalDeck, "2♣");
    addCardToDeck(myPersonalDeck, "A♠");
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "3♣");
    addCardToDeck(myPersonalDeck, "3♡");
    model.startGame(myPersonalDeck, false, 3, 1);
    model.discardDraw();
    model.discardDraw();
    model.discardDraw();
    Assert.assertFalse(model.isGameOver());
  }

  @Test
  public void testEditDrawCardsAfterStartGame() {
    List<Card> myPersonalDeck = new ArrayList<>();

    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "A♣");
    addCardToDeck(myPersonalDeck, "2♣");
    addCardToDeck(myPersonalDeck, "A♠");
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "3♣");
    addCardToDeck(myPersonalDeck, "3♡");
    model.startGame(myPersonalDeck, false, 3, 1);
    List<Card> drawNewCards = model.getDrawCards();
    Assert.assertThrows(UnsupportedOperationException.class, () ->
            drawNewCards.remove(foundCard("3♣")));
  }

  @Test
  public void incorrectValCardFoundation() {
    List<Card> myPersonalDeck = new ArrayList<>();
    addCardToDeck(myPersonalDeck, "A♠");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "3♠");
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "3♡");
    model.startGame(myPersonalDeck, false, 2, 1);
    model.moveToFoundation(0, 0);
    Assert.assertThrows(IllegalStateException.class, () -> model.moveToFoundation(1, 0));
  }

  @Test
  public void incorrectCardFoundation() {
    List<Card> myPersonalDeck = new ArrayList<>();
    addCardToDeck(myPersonalDeck, "A♠");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "2♠");
    addCardToDeck(myPersonalDeck, "2♡");

    model.startGame(myPersonalDeck, false, 2, 1);
    model.moveToFoundation(0, 0);
    Assert.assertThrows(IllegalStateException.class, () -> model.moveDrawToFoundation(0));
  }
}