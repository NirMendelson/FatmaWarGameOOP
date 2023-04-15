import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int warRound = 0;
		boolean gameOn = true;
		outerLoop:
			while (gameOn) {
				ArrayList<Parent_Unit> mainDeck = createDeck();
				ArrayList<Parent_Unit> playerDeck = new ArrayList<Parent_Unit>();
				ArrayList<Parent_Unit> computerDeck = new ArrayList<Parent_Unit>();
				dealCards(mainDeck, playerDeck, computerDeck);
				System.out.println("Welcome to Fatma Enhanced War Game!");
				sc.nextLine();
				printNumOfCards(playerDeck, computerDeck);
				innerLoop:
					while (enoughCards(playerDeck, computerDeck)) {
						if (playQuest() == false) {
							break outerLoop;
						}
						showCards(playerDeck, computerDeck);

						while (areCardsTheSame(playerDeck, computerDeck, warRound)) {
							if (enoughCardsForWar(playerDeck, computerDeck, warRound)) {
								warMode(playerDeck, computerDeck, warRound); 
								
								warRound = warRound + 4;
							}
							else {
								break innerLoop;
							}
						}
						compareAndAddCards(playerDeck, computerDeck, warRound);
						warRound = 0;
						printNumOfCards(playerDeck, computerDeck);	
					}
				warRound = 0;
				gameOn = playAgain(playerDeck, computerDeck);
			}
	}
	
//	public static void specialMove(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
//		if (playerDeck.get(0).category.equals("Ground")) {
//			computerDeck.
//		}
//	}

	// in war mode every player need to draw four cards
	public static void warMode(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {
		if (playerDeck.get(0).getcategory().equals("Navy")) {
			System.out.println("Navy War!");
		}
		else {
			System.out.println("War!");
		}
		sc.nextLine();
		System.out.print("AI ");
		System.out.print(computerDeck.get(0).getSecretCode());
		for (int i = 0; i<=(warRound/4); i++) {
			System.out.print("###");
			System.out.print(computerDeck.get(i*4+4).getSecretCode());
		}
		System.out.println("");

		System.out.print("Player ");
		System.out.print(playerDeck.get(0).getSecretCode());
		for (int i = 0; i<=(warRound/4); i++) {
			System.out.print("###");
			System.out.print(playerDeck.get(i*4+4).getSecretCode());
		}
		System.out.println("");
	}
	
	// A helper method to get the value of a card
			public static int getCardValue(String card) {
				int value = 0;
				try {
					value = Integer.parseInt(card);
				} catch (NumberFormatException e) {
					// It's not a number, so it must be a face card or a joker
					switch (card) {
					case "Jo":
						value = 15;
						break;
					case "A":
						value = 14;
						break;
					case "J":
						value = 11;
						break;
					case "Q":
						value = 12;
						break;
					case "K":
						value = 13;
						break;
					}
				}
				return value;
			}


			
		public static void compareAndAddCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {
			
			int playerSpecialPower = playerDeck.get(0).getSpecialPowerNumber();
			int computerSpecialPower = computerDeck.get(0).getSpecialPowerNumber();
			
			if (playerDeck.get(0 + warRound).wins(computerDeck.get(0 + warRound))) {
				// player wins
				// adding the player shown cards to the player deck
				for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
					playerDeck.add(playerDeck.get(i));
				}
				
				// adding the computer shown cards to the player deck
				for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
					playerDeck.add(computerDeck.get(i));
//					System.out.println("player special power is " + playerSpecialPower);
				}
				
				// removing the player shown cards
				for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
					playerDeck.remove(i);
				}
				
				// removing the computer shown cards
				for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
					computerDeck.remove(i);
				}
			}
			
			else if (computerDeck.get(0 + warRound).wins(playerDeck.get(0 + warRound))) {
				// computer wins
				// adding the computer shown cards to the computer deck
				for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
					computerDeck.add(computerDeck.get(i));
//					System.out.println("AI special power is " + computerSpecialPower);
				}
				
				// adding the player shown cards to the computer deck
				for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
					computerDeck.add(playerDeck.get(i));
				}
				
				// removing the player shown cards
				for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
					playerDeck.remove(i);
				}
				
				// removing the computer shown cards
				for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
					computerDeck.remove(i);
				}
			}
		}
//				
//    			// AI wins, add cards to the end of their deck
//				for (int i = 0; i <= 0 + warRound; i++) {
//					playerDeck.add(playerDeck.get(i));
//					playerDeck.add(computerDeck.get(i));
//				}
//				// remove the cards that were drawn
//				for (int i = 0; i <= 0 + warRound; i++) {
//					playerDeck.remove(i);
//					computerDeck.remove(i);
//				}
//			}
//			else {
//				// player wins, add cards to the end of their deck
//				for (int i = 0; i <= 0 + warRound; i++) {
//					computerDeck.add(playerDeck.get(i));
//					computerDeck.add(computerDeck.get(i));
//				}
//				// remove the cards that were drawn
//				for (int i = 0; i <= 0 + warRound; i++) {
//					playerDeck.remove(i);
//					computerDeck.remove(i);
//				}
//			} 
//		}

	// checking if the cards of the player and the computer are equal, works for war and non war
	public static boolean areCardsTheSame(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {
		if (playerDeck.get(0 + warRound).getSecretCode().equals(computerDeck.get(0 + warRound).getSecretCode())) {
			return true;
		}
		else {
			return false;
		}
	}

	// checks if the players have enough cards to continue playing
	public static boolean enoughCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
		if (playerDeck.isEmpty()) {
			System.out.println("AI wins");
		} 
		else if (computerDeck.isEmpty()) {
			System.out.println("Player wins");
		}
		else {
			return true;
		}
		return false;
	}

	// checks if the players have enough cards for "war"- in each war round you need to draw 4 cards
	public static boolean enoughCardsForWar(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {
		if (playerDeck.size() <= warRound*4+5) {
			System.out.println("Not enough cards");
			System.out.println("AI wins!");
		} 
		else if (computerDeck.size() <= warRound*4+5) {
			System.out.println("Not enough cards");
			System.out.println("Player wins!");
		}
		else {
			return true;
		}
		return false;
	}

	public static ArrayList<Parent_Unit> createDeck() {
		ArrayList<Parent_Unit> deck = new ArrayList<>();
		
		for (int i = 0; i < 11; i++) {
			Tank T = new Tank();
			deck.add(T);
		}
		for (int i = 0; i < 10; i++) {
			Artillery A = new Artillery();
			deck.add(A);
		}
		for (int i = 0; i < 8; i++) {
			Combat_Engineering C = new Combat_Engineering();
			deck.add(C);
		}
		for (int i = 0; i < 10; i++) {
			Fighter_Jet F = new Fighter_Jet();
			deck.add(F);
		}
		for (int i = 0; i < 11; i++) {
			Helicopter H = new Helicopter();
			deck.add(H);
		}
		for (int i = 0; i < 8; i++) {
			Battleship B = new Battleship();
			deck.add(B);
		}
		for (int i = 0; i < 3; i++) {
			Submarine S = new Submarine();
			deck.add(S);
		}
		
		
		Collections.shuffle(deck);
		
		return deck;
	}
	

	// split the deck between the computer and the player
	public static void dealCards(ArrayList<Parent_Unit> mainDeck, ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
		for (int i = 0; i < 30; i++) {
			playerDeck.add(mainDeck.remove(0));
			computerDeck.add(mainDeck.remove(0));
		}
	}

	// show the first card of each player
	public static void showCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
		// DEBUGGING
//		System.out.println("AI " + computerDeck.get(0).getSecretCode() + " " + computerDeck.get(0).getNumOfWinsChild() + " " + computerDeck.get(0).getcategory() + " " + computerDeck.get(0).getNumOfWins());
//		System.out.println("Player " + playerDeck.get(0).getSecretCode() + " " + playerDeck.get(0).getNumOfWinsChild() + " " + playerDeck.get(0).getcategory() + " " + playerDeck.get(0).getNumOfWins());
//		System.out.println("");

		int playerSpecialPower = playerDeck.get(0).specialPower();
		int computerSpecialPower = computerDeck.get(0).specialPower();
		
		
		String computerAddCardsLine = "";
		String playerAddCardsLine = "";
		
		if (playerSpecialPower == 0) {
			System.out.println("AI " + computerDeck.get(0).getSecretCode());
		}
		else {
			System.out.print("AI " + computerDeck.get(0).getSecretCode());
			if ((playerDeck.get(0).getcategory().equals("Air")) && (playerSpecialPower >= 4)) {
				for (int i = 0; i < 4; i++) {
					System.out.print("#");
				}
			}
			else {
				for (int i = 0; i < playerSpecialPower; i++) {
					System.out.print("#");
				}
				System.out.println("");
				playerAddCardsLine = "Player " + playerDeck.get(0).getcategory() + " special power added " + playerSpecialPower + " cards";
			}
			
		}
		
		if (computerSpecialPower == 0) {
			System.out.println("Player " + playerDeck.get(0).getSecretCode());
		}
		else {
			System.out.print("Player " + playerDeck.get(0).getSecretCode());
			if ((computerDeck.get(0).getcategory().equals("Air")) && (computerSpecialPower >= 4)) {
				for (int i = 0; i < 4; i++) {
					System.out.print("#");
				}
			}
			else {
				for (int i = 0; i < computerSpecialPower; i++) {
					System.out.print("#");
				}
				System.out.println("");
				computerAddCardsLine = "AI " + computerDeck.get(0).getcategory() + " special power added " + computerSpecialPower + " cards";
			}
			
		}
		if (computerAddCardsLine != "") {
			System.out.println(computerAddCardsLine);
		}
		if (playerAddCardsLine != "") {
			System.out.println(playerAddCardsLine);
		}
		sc.nextLine();
	}
		
		
//		
//		
//		if (playerDeck.get(0).getNumOfWins() == 0) {
//			System.out.println("AI " + computerDeck.get(0).getSecretCode());
//		}
//		else {
//			if (playerDeck.get(0).getcategory().equals("Ground")) {
//				System.out.println("AI " + computerDeck.get(0).getSecretCode());
//				for (int i = 0; i < playerDeck.get(0).getNumOfWinsChild(); i++) {
//					System.out.print("#");
//				}
//				if (playerDeck.get(0).getNumOfWinsChild() > 0) {
//					playerAddCardsLine = "Player Ground special power added " + playerDeck.get(0).getNumOfWinsChild() + " cards";
//				}
//			}
//			else if (playerDeck.get(0).getcategory().equals("Air")) {
//				System.out.print("AI " + computerDeck.get(0).getSecretCode());
//				if (playerDeck.get(0).getNumOfWins() < 4) {
//					for (int i = 0; i < playerDeck.get(0).getNumOfWins(); i++) {
//						System.out.print("#");
//					}
//				}
//				else {
//					for (int i = 0; i < 4; i++) {
//						System.out.print("#");
//					}
//				}
//				System.out.println("");
//				playerAddCardsLine = "Player Air special power added " + playerDeck.get(0).getNumOfWins() + " cards";
//			}
//			else {
//				Random random = new Random();
//				int randomNumber = random.nextInt(100) + 1; // 1 to 100
//				if (randomNumber <= 30) {
//					System.out.print("AI " + computerDeck.get(0).getSecretCode());
//					System.out.print("##");
//					System.out.println("");
//					playerAddCardsLine = "Player Navy special power added 2 cards";
//				}
//				else if ((randomNumber > 30) && (randomNumber <= 50)) {
//					System.out.print("AI " + computerDeck.get(0).getSecretCode());
//					System.out.print("#");
//					System.out.println("");
//					playerAddCardsLine = "Player Navy special power added 1 cards";
//				}
//				else {
//					System.out.println("AI " + computerDeck.get(0).getSecretCode());
//					playerAddCardsLine = "Player Navy special power added 0 cards";
//				}
//			}
//		}
//
//
//		if (computerDeck.get(0).getNumOfWins() == 0) {
//			System.out.println("Player " + playerDeck.get(0).getSecretCode());
//		}
//		else {
//			if (computerDeck.get(0).getcategory().equals("Ground")) {
//				System.out.println("Player " + playerDeck.get(0).getSecretCode());
//				for (int i = 0; i < computerDeck.get(0).getNumOfWinsChild(); i++) {
//					System.out.print("#");
//				}
//				
//				if (computerDeck.get(0).getNumOfWinsChild() > 0) {
//					System.out.println("");
//					computerAddCardsLine = "AI Ground special power added " + computerDeck.get(0).getNumOfWinsChild() + " cards";
//				}
//			}
//			else if (computerDeck.get(0).getcategory().equals("Air")) {
//				System.out.print("Player " + playerDeck.get(0).getSecretCode());
//				if (computerDeck.get(0).getNumOfWins() < 4) {
//					for (int i = 0; i < computerDeck.get(0).getNumOfWins(); i++) {
//						System.out.print("#");
//					}
//				}
//				else {
//					for (int i = 0; i < 4; i++) {
//						System.out.print("#");
//					}
//				}
//				System.out.println("");
//				computerAddCardsLine = "AI Air special power added " + computerDeck.get(0).getNumOfWins() + " cards";
//			}
//			else {
//				Random random = new Random();
//				int randomNumber = random.nextInt(100) + 1; // 1 to 100
//				if (randomNumber <= 30) {
//					System.out.print("Player " + playerDeck.get(0).getSecretCode());
//					System.out.print("##");
//					System.out.println("");
//					computerAddCardsLine = "AI Navy special power added 2 cards";
//				}
//				else if ((randomNumber > 30) && (randomNumber <= 50)) {
//					System.out.print("Player " + playerDeck.get(0).getSecretCode());
//					System.out.print("#");
//					System.out.println("");
//					computerAddCardsLine = "AI Navy special power added 1 cards";
//				}
//				else {
//					System.out.println("Player " + playerDeck.get(0).getSecretCode());
//					computerAddCardsLine = "AI Navy special power added 0 cards";
//				}
//			}
//		}
//		if (computerAddCardsLine != "") {
//			System.out.println(computerAddCardsLine);
//		}
//		if (playerAddCardsLine != "") {
//			System.out.println(playerAddCardsLine);
//		}
//		sc.nextLine();
//	}
	

		
		

	// asking the player if he wants to play, if he reply "no" then the computer wins
	public static boolean playQuest() {
		System.out.println("Play? ");
		while (true) {
			String userInput = sc.nextLine().toLowerCase();
			if (userInput.toLowerCase().equals("no")) {
				System.out.println("AI wins! Good bye");
				return false;
			}
			else if (userInput.equals("")) {
				return true;
			}
			else {
				System.out.println("The input is wrong. Please try again.");
			}
		}
	}

	// prints how many cards each player has in their decks
	public static void printNumOfCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
		int compGroundCount = 0;
		int compAirCount = 0;
		int compNavyCount = 0;
		int playerGroundCount = 0;
		int playerAirCount = 0;
		int playerNavyCount = 0;

		for (int i = 0; i < computerDeck.size(); i++) {
			if (computerDeck.get(i) instanceof Tank || computerDeck.get(i) instanceof Artillery || computerDeck.get(i) instanceof Combat_Engineering) {
				compGroundCount++;
			}
			else if (computerDeck.get(i) instanceof Fighter_Jet || computerDeck.get(i) instanceof Helicopter) {
				compAirCount++;
			}
			else {
				compNavyCount++;
			}
		}

		for (int i = 0; i < playerDeck.size(); i++) {
			if (playerDeck.get(i) instanceof Tank || playerDeck.get(i) instanceof Artillery || playerDeck.get(i) instanceof Combat_Engineering) {
				playerGroundCount++;
			}
			else if (playerDeck.get(i) instanceof Fighter_Jet || playerDeck.get(i) instanceof Helicopter) {
				playerAirCount++;
			}
			else {
				playerNavyCount++;
			}
		}

		System.out.println("AI " + compGroundCount + " Ground, " + compAirCount + " Air, " + compNavyCount + " Navy ");
		System.out.println("Player " + playerGroundCount + " Ground, " + playerAirCount + " Air, " + playerNavyCount + " Navy ");
	}

	

	// asking the player if he wants to play again, if he reply "no" then the game is over
	public static boolean playAgain(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
		System.out.println("Would you like to start a new game?");
		while (true) {
			String userInput = sc.nextLine().toLowerCase();
			if (userInput.toLowerCase().equals("no")) {
				System.out.println("Good bye");
				return false;
			}
			else if (userInput.equals("")) {
				return true;
			}
			else {
				System.out.println("The input is wrong. Please try again.");
			}
		}
	}



}
