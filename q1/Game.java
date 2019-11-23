package q1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game {

	private Player player1;
	private Player player2;
	private DeckOfCards deckOfCards;

	//this static array for storing the cards and add them to the winner.
	private static ArrayList<Card> cards = new ArrayList<Card>();

	private static final String winnerMessage = "The Winner Is: ";

	public Game(Player player1, Player player2) {

		this.player1 = player1;
		this.player2 = player2;
		this.deckOfCards = new DeckOfCards();

	}

	public void start() {
		
		this.deckOfCards.shuffle();
		this.dealingCards();

		while (true)
			showCards();

	}

	public void dealingCards() {

		for (int i = 0; i < deckOfCards.getDeck().size(); i++) {
			if (i % 2 == 0)
				player1.addCard(deckOfCards.dealCard());
			else
				player2.addCard(deckOfCards.dealCard());
		}

	}

	/**
	 * each player show his card for the current round, and display them by showMessageDialog,
	 * if one of the cards is null, it means the player has no cards and he lost the game.
	 * 
	 */
	public void showCards() {

		Card player1Card = player1.getFirstCard();
		Card player2Card = player2.getFirstCard();


		// if one of the cards is null, game over.
		if (player1Card == null) {

			JOptionPane.showMessageDialog(null, winnerMessage + player2.getPlayerName());

			System.exit(1);

		} else if (player2Card == null) {

			JOptionPane.showMessageDialog(null, winnerMessage + player1.getPlayerName());

			System.exit(1);
		}

		Player roundWinner = this.checkWinner(player1Card, player2Card);

		// it means we are in war
		if (roundWinner == null) {

			JOptionPane.showMessageDialog(null,

					"Player1 Card: " + player1Card + "   " + "Player2 Card: " + player2Card + "\n\n WAR!!!");

			// we are in war, remove the cards from the players and add them into array

			addCardsToTheWinner(null);
			addCardsToTheWinner(null);

		}

		else {

			String message = "Player1 Card: " + player1Card + "   " + "Player2 Card: " + player2Card
					+ "\n\n Winner for this round: " + roundWinner;

			JOptionPane.showMessageDialog(null, message);

		}

	}

	/**
	 * 
	 * @param player1Card
	 * @param player2Card
	 * @return the winner for the current round, if the cards equals return null
	 */
	public Player checkWinner(Card player1Card, Card player2Card) {

		if (player1Card.getPower() == player2Card.getPower()) {

			addCardsToTheWinner(null);

			return null;
		}

		if (player1Card.getPower() > player2Card.getPower()) {

			addCardsToTheWinner(player1);

			return this.player1;

		}

		addCardsToTheWinner(player2);

		return this.player2;

	}
	/**
	 * 
	 * @param winner for the current round
	 * if we have winner for the current round, add the cards to the static array, and add the cards to the winner,
	 * if we do not have winner for the current round, we store the cards, and after the war,
	 * add all of them to the winner.
	 *  
	 */

	public void addCardsToTheWinner(Player winner) {

		// remove the cards from the players and save them into array
		if (winner == player1) {

			cards.add(player1.getAndRemoveFirstCard());
			cards.add(player2.getAndRemoveFirstCard());
			winner.addCards(cards);

			cards = new ArrayList<Card>();

		} else if (winner == player2) {

			cards.add(player2.getAndRemoveFirstCard());
			cards.add(player1.getAndRemoveFirstCard());
			winner.addCards(cards);

			cards = new ArrayList<Card>();
			
			
		}
		

		if (winner == null) {

			cards.add(player1.getAndRemoveFirstCard());
			cards.add(player2.getAndRemoveFirstCard());

		}

	}

	public static void main(String[] args) {

		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		Game game = new Game(player1, player2);
		game.start();
		

	}

}
