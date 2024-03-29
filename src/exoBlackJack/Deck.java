package exoBlackJack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	private List<Card> cardList;

	// Constructor
	public Deck() {
		cardList = new LinkedList<>();
		populateDeck();
		shuffleDeck();
	}

	// Methods

	public Card drawCard() throws NoMoreCardsInDeckException {
		try {
			return cardList.remove(0);
		} catch (Exception e) {
			throw new NoMoreCardsInDeckException(e);
		}
	}

	private void populateDeck() {
		for (CardValues cardValues : CardValues.values()) {
			for (CardSuits cardSuits : CardSuits.values()) {
				final Card newCard = new Card(cardValues, cardValues.getValue(), cardSuits);
				cardList.add(newCard);
			}
		}
	}

	private void shuffleDeck() {
		Collections.shuffle(cardList);
	}

	// Get + Set

	public List<Card> getCardList() {
		return cardList;
	}

}
