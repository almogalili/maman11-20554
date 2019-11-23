package q1;
import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {

	private ArrayList<Card> deck;
	private int currentCard;

	private static final int NUMBER_OF_CARDS = 52;
	private static final SecureRandom randomNumbers = new SecureRandom();

	public DeckOfCards() {

		String faces[] = {"Duece", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King",  "Ace"};
		String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

		this.deck = new ArrayList<Card>();
		this.currentCard = 0;

		for (int i = 0; i < NUMBER_OF_CARDS; i++) {

			this.deck.add(i, new Card(faces[i % 13], suits[i / 13], i % 13));

		}

	}

	public void shuffle() {

		this.currentCard = 0;

		for (int first = 0; first < NUMBER_OF_CARDS; first++) {

			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			Card card = this.deck.set(first, this.deck.get(second));
			this.deck.set(second, card);

		}

	}

	public Card dealCard() {

		if (this.currentCard < this.deck.size()) {
			Card card = this.deck.get(currentCard);
			this.currentCard++;
			return card;
		}
		return null;

	}

	public ArrayList<Card> getDeck() {
		
		return this.deck;
		
	}

}
