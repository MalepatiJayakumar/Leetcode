package cs3500.klondike.view;

import java.io.IOException;

import cs3500.klondike.model.hw02.Card;
import cs3500.klondike.model.hw02.KlondikeModel;
import cs3500.klondike.model.hw02.Rank;
import cs3500.klondike.model.hw02.Suit;

/**
 * The KlondikeTextualView class represents a textual
 * view of a Klondike Solitaire game.
 * It displays information about the game's draw pile,
 * foundation piles, and cascade piles in text format.
 */

public class KlondikeTextualView implements TextView,TextualView {
  private final KlondikeModel model;
  private Appendable ap = null;
  /**
   * Constructs a KlondikeTextualView with the specified Klondike model.
   *
   * @param model The Klondike model to be displayed.
   */

  public KlondikeTextualView(KlondikeModel model) {
    this.model = model;
  }

  public KlondikeTextualView(KlondikeModel model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  /**
   * Generates a textual representation of the current state of the Klondike game.
   *
   * @return A string containing info about the draw pile, foundation piles, and cascade piles.
   */

  @Override
  public String toString() {
//    StringBuilder sb = new StringBuilder(ap);
    if (model.getDrawCards() == null) {
      return " ";
    }
    try {
      ap.append("Draw: ");
      ap.append(drawPileToString());
      ap.append("\n");

      ap.append("Foundation: ");
      ap.append(foundationPilesToString());
      ap.append("\n");
      ap.append(cascadePilesToString());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return ap.toString();
  }

  private String drawPileToString() {
    StringBuilder sb = new StringBuilder();
    if (model.getDrawCards() == null) {
      return " ";
    }
    for (int i = 0; i < model.getNumDraw(); i++) {
      Card card = model.getDrawCards().get(i);
      sb.append(cardToString(card));

      if (i < model.getNumDraw() - 1) {
        sb.append(", ");
      }
    }

    return sb.toString();
  }

  private String cardToString(Card card) {
    Rank rank = card.getRank();
    Suit suit = card.getSuit();
    return rank + suit.toString();
  }


  private String foundationPilesToString() {
    StringBuilder sb = new StringBuilder();
    if (model.getDrawCards() == null) {
      return " ";
    }
    for (int i = 0; i < model.getNumFoundations(); i++) {
      Card topCard = model.getCardAt(i);

      if (topCard == null) {
        sb.append("<none>");
      } else {
        sb.append(cardToString(topCard));
      }

      if (i < model.getNumFoundations() - 1) {
        sb.append(", ");
      }
    }

    return sb.toString();
  }


  private String cascadePilesToString() {
    StringBuilder sb = new StringBuilder();
    if (model.getDrawCards() == null) {
      return " ";
    }
    for (int pileNum = 0; pileNum < model.getNumPiles(); pileNum++) {
      sb.append(" ");

      for (int card = 0; card < model.getPileHeight(pileNum); card++) {
        if (model.isCardVisible(pileNum, card)) {
          Card visibleCard = model.getCardAt(pileNum, card);
          sb.append(cardToString(visibleCard));
        } else {
          sb.append("?");
        }

        if (card < model.getPileHeight(pileNum) - 1) {
          sb.append(" ");
        }
      }

      if (pileNum < model.getNumPiles() - 1) {
        sb.append("  ");
      }
    }

    return sb.toString();
  }

	@Override
	public String render() throws IOException {
		if (model.getDrawCards() == null) {
			return "";
		}
		try {
			ap.append("Draw: ");
			ap.append(drawPileToString());
			ap.append("\n");
			ap.append("Foundation: ");
			ap.append(foundationPilesToString());
			ap.append("\n");
			ap.append(cascadePilesToString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ap.toString();
	}

}