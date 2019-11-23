package q1;
import java.util.ArrayList;

public class Player {

	private final String playerName;
	private ArrayList<Card> cards;

	public Player(String name) {
		
		this.playerName = name;
		this.cards = new ArrayList<Card>();
		
	}

	public ArrayList<Card> getCards() {
		
		return this.cards;
		
	}

	public String getPlayerName() {
		
		return this.playerName;
		
	}

	public void addCard(Card card) {
		
		this.cards.add(card);
		
	}

	public void addCards(ArrayList<Card> cards) {

		this.cards.addAll(cards);

	}

	public Card getAndRemoveFirstCard() {

		if(this.cards.size() != 0)
		return this.cards.remove(0);
		
		return null;

	}
	public Card getFirstCard()
	{
		if(this.cards.size() != 0)
		return this.cards.get(0);

		return null;
	}

	public String toString() {
		
		return this.getPlayerName();
		
	}

}















