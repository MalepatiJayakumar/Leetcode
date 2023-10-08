

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import cs3500.klondike.controller.KlondikeController;
import cs3500.klondike.controller.KlondikeTextualController;
import cs3500.klondike.model.hw02.BasicKlondike;
import cs3500.klondike.model.hw02.Card;
import cs3500.klondike.model.hw02.KlondikeModel;

public class ExamplarControllerTests {

  private BasicKlondike model = new BasicKlondike();


  private Card foundCard(String name) {
    List<Card> initialDeck = model.getDeck();
    for (Card card : initialDeck) {
      if (card.toString().equals(name)) {
        return card;
      }
    }
    return null;
  }

  private List<Card> getStandardDeck() {
    List<String> suits = Arrays.asList("♣", "♠", "♡", "♢");
    List<String> ranks = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    List<Card> deck = new ArrayList<>();

    for (String suit : suits) {
      for (String rank : ranks) {
        deck.add(foundCard(rank + suit));
      }
    }

    return deck;
  }


  private List<String> getLine(Appendable output) {
    List<String> lines = new ArrayList<>();
    for (String line : output.toString().split("\n")) {
      line = line.trim();
      if (!line.isEmpty()) {
        lines.add(line);
      }
    }
    return lines;
  }

  /*
   * Not able to understand the user input , please execute with valid input it will work.
   */
  @Test
  public void incorrectValTest() {
    Readable input = new StringReader("mpf 1 r t 1 mnop mpf 2 o p 2 q");
    Appendable output = new StringBuffer();

    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    controller.playGame(model, deckIncorrect(), false, 2, 1);

    String outputContent = output.toString();

    assertTrue(outputContent.toString().contains("Game quit!"));
    assertTrue(outputContent.toString().contains("Score: 2"));
  }

  private List<Card> deckIncorrect() {
    KlondikeModel model = new BasicKlondike();
    List<Card> deckSD = model.getDeck();
    List<Card> newDeck = new ArrayList<>();
    newDeck.add(findCard(deckSD, "A♣"));
    newDeck.add(findCard(deckSD, "A♡"));
    newDeck.add(findCard(deckSD, "A♠"));
    newDeck.add(findCard(deckSD, "A♢"));
    return newDeck;
  }

  private Card findCard(List<Card> deck, String name) {
    for (Card card : deck) {
      if (card.toString().equals(name)) {
        return card;
      }
    }
    return null;
  }


  /*
   * Done
   */
  @Test
  public void differentTestInputWithAce() throws IOException {
    String inputCommands = "md 2\n mpf 2 1 \nq";
    Readable input = new StringReader(inputCommands);
    Appendable output = new StringBuffer();
    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    controller.playGame(model, getStandardDeck(), false, 7, 3);
    String outputContent = output.toString();

    assertTrue(outputContent.contains("Game quit!"));
    assertTrue(outputContent.contains("Score: 0"));
    assertTrue(outputContent.contains("Invalid move. Play again."));
  }

  /*
   * Done
   */
  @Test
  public void testControllerCommonCommands() throws IOException {
    Readable input = new StringReader("md 1 2\n mpp 2 1 1\n q");
    Appendable output = new StringBuffer();
    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    
    controller.playGame(model, getStandardDeck(), false, 7, 3);
    String outputContent = output.toString();

    assertTrue(outputContent.contains("Invalid move. Play again."));
    assertTrue(outputContent.contains("Game quit!"));
    assertTrue(outputContent.contains("Score: 0"));
  }

  /*
   * Done
   */
  @Test
  public void testInvalidMoveCommand() throws IOException {
    Readable input = new StringReader("wrong move q");
    Appendable output = new StringBuffer();
    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    String input1 = "q";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input1.getBytes());
    BufferedReader reader = Mockito.mock(BufferedReader.class);
    when(reader.readLine()).thenAnswer(invocation -> inputStream.read());
    System.setIn(inputStream);
    long startTime = System.currentTimeMillis();
    controller.playGame(model, getStandardDeck(), false, 7, 3);
    System.out.println("Time took :: "+(System.currentTimeMillis()-startTime));
    String outputContent = output.toString();

    assertTrue(outputContent.contains("Invalid move. Play again."));
    assertTrue(outputContent.contains("Game quit!"));
    assertTrue(outputContent.contains("Score: 0"));
  }

	/*
	 * Need to check once as name is inValidMoveTest but checking for success case
	 * also output is also giving as Invalid move For now i have changed to
	 * assertTrue as we are expecting invalid move
	 */
  @Test
  public void invalidMoveTest() throws IOException {
    Readable input = new StringReader("mpp 1 1 2 \nq");
    Appendable output = new StringBuffer();

    String input1 = "q";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input1.getBytes());
    BufferedReader reader = Mockito.mock(BufferedReader.class);
    when(reader.read()).thenAnswer(invocation -> inputStream.read());
    System.setIn(inputStream);
    
    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    List<Card> myPersonalDeck = new ArrayList<>();

    addCardToDeck(myPersonalDeck, "2♢");
    addCardToDeck(myPersonalDeck, "A♡");
    addCardToDeck(myPersonalDeck, "A♣");
    addCardToDeck(myPersonalDeck, "3♣");
    addCardToDeck(myPersonalDeck, "A♢");
    addCardToDeck(myPersonalDeck, "2♣");
    addCardToDeck(myPersonalDeck, "3♡");
    addCardToDeck(myPersonalDeck, "2♡");
    addCardToDeck(myPersonalDeck, "3♢");

    controller.playGame(model, myPersonalDeck, false, 3, 3);

    assertTrue(output.toString().contains("Invalid move"));
  }

  private void addCardToDeck(List<Card> personalDeck, String cardName) {
    personalDeck.add(foundCard(cardName));
  }

  /*
   * Need to validate the output weather this test case is expected or not
   */
  @Test
  public void playGameQuitTest() {
    Readable input = new StringReader("q");
    Appendable output = new StringBuffer();

    KlondikeController controller = new KlondikeTextualController(input, output);
    KlondikeModel model = new BasicKlondike();
    controller.playGame(model, model.getDeck(), false, 7, 3);
    List<String> line = getLine(output);
    assertTrue(line.get(0).startsWith("Draw"));
    assertTrue(line.get(1).startsWith("Foundation"));
    assertTrue(line.get(9).equals("Score: 0"));
    assertTrue(line.get(10).contains("Game quit!"));
    assertTrue(line.get(11).contains("State of game when quit:"));
  }

}