package cs3500.klondike.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import cs3500.klondike.model.hw02.Card;
import cs3500.klondike.model.hw02.KlondikeModel;
import cs3500.klondike.view.KlondikeTextualView;

public class KlondikeTextualController implements KlondikeController {

  private Readable rd = null;
  private Appendable ap = null;
  private final Scanner scanner;
  private KlondikeTextualView view = null;

  public KlondikeTextualController(Readable r, Appendable a) {
    if (r == null || a == null) {
      System.out.println(rd);
      System.out.println(ap);
      throw new IllegalArgumentException("Readable and Appendable cannot be null");
    }
    this.rd = r;
    this.ap = a;
    this.scanner = new Scanner(rd);
  }

  @Override
	public void playGame(KlondikeModel model, List<Card> deck, boolean shuffle, int numPiles, int numDraw) {
		this.view = new KlondikeTextualView(model);
		if (model == null) {
			throw new IllegalArgumentException("Model cannot be null");
		}
		model.startGame(deck, shuffle, numPiles, numDraw);
		KlondikeTextualView klondikeTextualView = new KlondikeTextualView(model, ap);
		try {
			while (!model.isGameOver()) {
				klondikeTextualView.render();
				ap.append("\nScore: ").append(Integer.toString(model.getScore())).append("\n");
				String userInput = scanner.nextLine();
				processUserInput(model, userInput);
			}
			if (model.getScore() == model.getNumFoundations()) {
				transmitGameState("You win!");
			} else {
				transmitGameState("Game over. Score: " + model.getScore());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processUserInput(KlondikeModel model, String userInput) throws Exception {
		boolean validInput = false;
		while(!validInput) {
			String[] token = userInput.split("\\s");
			
			if(token.length == 0) {
				transmitGameState("Invalid input. Play again.");
				userInput = getUserInput();
				continue;
			}
			String command = token[0].toLowerCase();
			try {
				switch (command) {
				case "mpp":
					if (token.length != 4) {
						throw new IllegalArgumentException("Invalid input format for 'mpp'.");
					}
					int sourcePileIndex = parseInteger(token[1]);
					int numCardsToMove = parseInteger(token[2]);
					int destinationPileIndex = parseInteger(token[3]);
					model.movePile(sourcePileIndex - 1, numCardsToMove, destinationPileIndex - 1);
					validInput = true;
					break;
				case "md":
					if (token.length != 2) {
						throw new IllegalArgumentException("Invalid input format for 'md'.");
					}
					int drawDestinationIndex = parseInteger(token[1]);
					model.moveDraw(drawDestinationIndex - 1);
					validInput = true;
					break;
				case "mpf":
					if (token.length != 3) {
						throw new IllegalArgumentException("Invalid input format for 'mpf'.");
					}
					int sourcePileIndexMPF = parseInteger(token[1]);
					int foundationIndex = parseInteger(token[2]);
					model.moveToFoundation(sourcePileIndexMPF - 1, foundationIndex - 1);
					validInput = true;
					break;
				case "mdf":
					if (token.length != 2) {
						throw new IllegalArgumentException("Invalid input format for 'mdf'.");
					}
					int foundationIndexMDF = parseInteger(token[1]);
					model.moveDrawToFoundation(foundationIndexMDF - 1);
					validInput = true;
					break;
				case "dd":
					if (token.length != 1) {
						throw new IllegalArgumentException("Invalid input format for 'dd'.");
					}
					model.discardDraw();
					validInput = true;
					break;
				case "q":
				case "quit":
					transmitGameState("Game quit!");
					transmitGameState("State of game when quit:");
					transmitGameState(ap.toString());
					transmitGameState("Score: " + model.getScore());
					return; // Exit the method
				default:
					throw new IllegalArgumentException("Invalid command.");
				}
			}catch(Exception e) {
				 transmitGameState("Invalid move. Play again. " + e.getMessage());
		         userInput = getUserInput();
			}
		}
	}
  
	private void transmitGameState(String gameState) {
		try {
			ap.append(gameState).append("\n");
		} catch (IOException e) {
			throw new IllegalStateException("Error writing game state.", e);
		}
	}
	
	private int parseInteger(String input) {
	    try {
	        return Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Invalid number format.");
	    }
	}
	
	private String getUserInput() {
		System.out.println("Enter user input");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder input = new StringBuilder();
	    try {
	        int nextChar;
	        while ((nextChar = reader.read()) != -1) {
	            char c = (char) nextChar;
	            if (c == '\n') {
	                break;
	            }
	            input.append(c);
	        }
	    } catch (IOException e) {
	        throw new IllegalStateException("Error reading user input.", e);
	    }
	    return input.toString().trim();
	}
}