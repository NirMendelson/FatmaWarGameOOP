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

	// in war mode every player need to draw four cards
	public static void warMode(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {
		
		String playerAddCardsLine = "Player " + playerDeck.get(4 + warRound).getcategory() + " special power added " + playerDeck.get(4 + warRound).getSpecialPowerNumber() + " cards";
		String computerAddCardsLine = "AI " + computerDeck.get(4 + warRound).getcategory() + " special power added " + computerDeck.get(4 + warRound).getSpecialPowerNumber() + " cards";

		// if one of the card if navy so its navy war
		if (playerDeck.get(0).getcategory().equals("Navy") || computerDeck.get(0).getcategory().equals("Navy")) {
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
		for (int i = 0; i < playerDeck.get(warRound+4).getSpecialPowerNumber(); i++) {
			System.out.print("#");
		}
		System.out.println("");

		System.out.print("Player ");
		System.out.print(playerDeck.get(0).getSecretCode());
		for (int i = 0; i<=(warRound/4); i++) {
			System.out.print("###");
			System.out.print(playerDeck.get(i*4+4).getSecretCode());
		}
		for (int i = 0; i < computerDeck.get(warRound+4).getSpecialPowerNumber(); i++) {
			System.out.print("#");
		}
		System.out.println("");
		
		if (playerDeck.get(4 + warRound).getSpecialPowerNumber() != 0) {
			System.out.println(playerAddCardsLine);
		}
		if (computerDeck.get(4 + warRound).getSpecialPowerNumber() != 0) {
			System.out.println(computerAddCardsLine);
		}
	}

	// a function that checks who won and add the cards accordingly
	public static void compareAndAddCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck, int warRound) {

		int playerSpecialPower = 0;
		int computerSpecialPower = 0;
		
		if (playerDeck.get(0 + warRound).category.equals("Air") && playerDeck.get(0 + warRound).getSpecialPowerNumber() >= 4) {
			playerSpecialPower = 4;
		}
		else {
			playerSpecialPower = playerDeck.get(0 + warRound).getSpecialPowerNumber();
		}
		if (computerDeck.get(0 + warRound).category.equals("Air") && computerDeck.get(0 + warRound).getSpecialPowerNumber() >= 4) {
			computerSpecialPower = 4;
		}
		else {
			computerSpecialPower = computerDeck.get(0 + warRound).getSpecialPowerNumber();
		}

		if (playerDeck.get(0 + warRound).wins(computerDeck.get(0 + warRound))) {
			// player wins
			// adding the player shown cards to the player deck
			for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
				playerDeck.add(playerDeck.get(i));
			}

			// adding the computer shown cards to the player deck
			for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
				playerDeck.add(computerDeck.get(i));
			}

			// removing the player shown cards
			for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
				playerDeck.remove(0);
			}

			// removing the computer shown cards
			for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
				computerDeck.remove(0);
			}
		}

		else if (computerDeck.get(0 + warRound).wins(playerDeck.get(0 + warRound))) {
			// computer wins
			// adding the computer shown cards to the computer deck
			for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
				computerDeck.add(computerDeck.get(i));
			}

			// adding the player shown cards to the computer deck
			for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
				computerDeck.add(playerDeck.get(i));
			}

			// removing the computer shown cards
			for (int i = 0; i <= (0 + warRound + playerSpecialPower); i++) {
				computerDeck.remove(0);
			}
			
			// removing the player shown cards
			for (int i = 0; i <= (0 + warRound + computerSpecialPower); i++) {
				playerDeck.remove(0);
			}
		}
	}
	
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
	
	// a function that creates the deck
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
	
	// show the first card of each player and adding cards upside down if needed
	public static void showCards(ArrayList<Parent_Unit> playerDeck, ArrayList<Parent_Unit> computerDeck) {
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
				System.out.println("####");
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
				System.out.println("####");
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

	// printing how many cards each player has in their decks
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
