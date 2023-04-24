import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	private static ArrayList<Parent_Unit> mainDeck;
	private static ArrayList<Parent_Unit> playerDeck;
	private static ArrayList<Parent_Unit> computerDeck;
	private static int warRound = 0;
	private static int openCardAI = 0;
	private static int openCardPlayer = 0;
	
	
	public static void main(String[] args) {
		boolean gameOn = true;
		outerLoop:
			while (gameOn) {
				mainDeck = createDeck();
				playerDeck = new ArrayList<Parent_Unit>();
				computerDeck = new ArrayList<Parent_Unit>();
				dealCards();
				System.out.println("Welcome to Fatma Enhanced War Game!");
				sc.nextLine();
				printNumOfCards();
				innerLoop:
					while (decksNotEmpty()) {
						if (playQuest() == false) {
							break outerLoop;
						}
						if (enoughCards() == false) {
							break innerLoop;
						}
						showCards();

						while (areCardsTheSame()) {
							if (enoughCardsForWar()) {
								warMode(); 
								warRound += 4;
							}
							else {
								break innerLoop;
							}
						}
						compareAndAddCards();
						warRound = 0;
						openCardAI = 0;
						openCardPlayer = 0;
						
						printNumOfCards();	
					}
				warRound = 0;
				openCardAI = 0;
				openCardPlayer = 0;
				gameOn = playAgain();
			}
	}

	// in war mode every player need to draw four cards
	public static void warMode() {

		if (playerDeck.get(openCardPlayer).getcategory().equals("Navy") || computerDeck.get(openCardPlayer).getcategory().equals("Navy")) {
			System.out.println("Navy War!");
		}
		else {
			System.out.println("War!");
		}
		sc.nextLine();
		
		openCardAI = 0;
		openCardPlayer = 0;
		
		System.out.print("AI ");
		System.out.print(computerDeck.get(0).getSecretCode());
		for (int j = 0; j < playerDeck.get(0).getSpecialPowerNumber(); j++) {
			System.out.print("#");
		}
		for (int i = 0; i <=(warRound/4); i++) {
			
			System.out.print("###");
			int temporaryAI = openCardAI + 4 + playerDeck.get(openCardPlayer).getSpecialPowerNumber();
			int temporaryPlayer = openCardPlayer + 4 + computerDeck.get(openCardAI).getSpecialPowerNumber();
			openCardAI = temporaryAI;
			openCardPlayer = temporaryPlayer;
			if (i == warRound/4) {
				computerDeck.get(openCardAI).specialPower();
				playerDeck.get(openCardPlayer).specialPower();
			}
			System.out.print(computerDeck.get(openCardAI).getSecretCode());
			for (int j = 0; j < playerDeck.get(openCardPlayer).getSpecialPowerNumber(); j++) {
				System.out.print("#");
			}
		}
		System.out.println("");
		
		openCardAI = 0;
		openCardPlayer = 0;
		System.out.print("Player ");
		System.out.print(playerDeck.get(0).getSecretCode());
		for (int j = 0; j < computerDeck.get(openCardAI).getSpecialPowerNumber(); j++) {
			System.out.print("#");
		}
		for (int i = 0; i <=(warRound/4); i++) {
			
			System.out.print("###");
			int temporaryAI = openCardAI + 4 + playerDeck.get(openCardPlayer).getSpecialPowerNumber();
			int temporaryPlayer = openCardPlayer + 4 + computerDeck.get(openCardAI).getSpecialPowerNumber();
			openCardAI = temporaryAI;
			openCardPlayer = temporaryPlayer;
			System.out.print(playerDeck.get(openCardPlayer).getSecretCode());
			if (computerDeck.get(openCardAI).getcategory().equals("Air") && computerDeck.get(openCardAI).getSpecialPowerNumber() >=4) {
				System.out.print("####");
			}
			else {
				for (int j = 0; j < computerDeck.get(openCardAI).getSpecialPowerNumber(); j++) {
					System.out.print("#");
				}
			}
		}
		System.out.println("");
		
		
		if (computerDeck.get(openCardAI).getSpecialPowerNumber() != 0) {
			System.out.println("AI " + computerDeck.get(openCardAI).getcategory() + " special power added " + computerDeck.get(openCardAI).getSpecialPowerNumber() + " cards");
		}
		if (playerDeck.get(openCardPlayer).getSpecialPowerNumber() != 0) {
			System.out.println("Player " + playerDeck.get(openCardPlayer).getcategory() + " special power added " + playerDeck.get(openCardPlayer).getSpecialPowerNumber() + " cards");
		}

	}
	
	public static void activateSpecialPower(String name, int index) {
		if (name.equals("AI")) {
			computerDeck.get(index).specialPower();
		}
		else {
			playerDeck.get(index).specialPower();
		}
	}

	// a function that checks who won and add the cards accordingly
	public static void compareAndAddCards() {
		
		int AISpecialPower = computerDeck.get(openCardAI).getSpecialPowerNumber();
		int PlayerspecialPower = playerDeck.get(openCardPlayer).getSpecialPowerNumber();

		
		if (playerDeck.get(openCardPlayer).wins(computerDeck.get(openCardAI))) {
				
			
			// player wins
			// adding the player shown cards to the player deck
			for (int i = 0; i <= (openCardPlayer + AISpecialPower); i++) {
				playerDeck.add(playerDeck.get(i));
			}

			// adding the computer shown cards to the player deck
			for (int i = 0; i <= (openCardAI + PlayerspecialPower); i++) {
				playerDeck.add(computerDeck.get(i));
			}

			// removing the player shown cards
			for (int i = 0; i <= (openCardPlayer + AISpecialPower); i++) {
				playerDeck.remove(0);
			}

			// removing the computer shown cards
			for (int i = 0; i <= (openCardAI + PlayerspecialPower); i++) {
				computerDeck.remove(0);
			}
		}

		else if (computerDeck.get(openCardAI).wins(playerDeck.get(openCardPlayer))) {
			// computer wins
			// adding the computer shown cards to the computer deck
			for (int i = 0; i <= (openCardAI + PlayerspecialPower); i++) {
				computerDeck.add(computerDeck.get(i));
			}

			// adding the computer shown cards to the player deck
			for (int i = 0; i <= (openCardPlayer + AISpecialPower); i++) {
				computerDeck.add(playerDeck.get(i));
			}

			// removing the computer shown cards
			for (int i = 0; i <= (openCardAI + PlayerspecialPower); i++) {
				computerDeck.remove(0);
			}
			
			// removing the player shown cards
			for (int i = 0; i <= (openCardPlayer + AISpecialPower); i++) {
				playerDeck.remove(0);
			}
		}
	}
	
	// checking if the cards of the player and the computer are equal, works for war and non war
	public static boolean areCardsTheSame() {
		if (playerDeck.get(openCardPlayer).getSecretCode().equals(computerDeck.get(openCardAI).getSecretCode())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean decksNotEmpty() {
		if (playerDeck.isEmpty()) {
			System.out.println("Not enough cards");
			System.out.println("AI wins");
		} 
		else if (computerDeck.isEmpty()) {
			System.out.println("Not enough cards");
			System.out.println("Player wins");
		}
		else {
			return true;
		}
		return false;
	}
	
	// checks if the players have enough cards to continue playing
	public static boolean enoughCards() {

		if (computerDeck.size() < (playerDeck.get(0).getSpecialPowerNumber() + 1) || (playerDeck.size() < (computerDeck.get(0).getSpecialPowerNumber() + 1))) {
			System.out.println("AI " + computerDeck.get(0).getSecretCode());
			System.out.println("Player " + playerDeck.get(0).getSecretCode());	
			System.out.println("AI " + computerDeck.get(0).getcategory() + " special power added " + computerDeck.get(0).getSpecialPowerNumber() + " cards");
			System.out.println("Player " + playerDeck.get(openCardPlayer).getcategory() + " special power added " + playerDeck.get(openCardPlayer).getSpecialPowerNumber() + " cards");
			System.out.println("Not enough cards");
			if (computerDeck.size() < (computerDeck.get(0).getSpecialPowerNumber() + 1)) {
				System.out.println("Player wins");
			}
			else {
				System.out.println("AI wins");
			}
			return false;
		}
		else {
			return true;
		}
	}
	
	// checks if the players have enough cards for "war"- in each war round you need to draw 4 cards
	public static boolean enoughCardsForWar() {
		if (playerDeck.size() < openCardPlayer + computerDeck.get(openCardAI).getSpecialPowerNumber() + 3) {
			System.out.println("Not enough cards");
			System.out.println("AI wins!");
		} 
		else if (computerDeck.size() < openCardAI + playerDeck.get(openCardPlayer).getSpecialPowerNumber() + 3) {
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
		
		for (int i = 0; i < deck.size(); i++) {
			deck.get(i).setToZero();
		}
		
		Collections.shuffle(deck);

		return deck;
	}

	// split the deck between the computer and the player
	public static void dealCards() {
		for (int i = 0; i < 30; i++) {
			playerDeck.add(mainDeck.remove(0));
			computerDeck.add(mainDeck.remove(0));
		}
	}
	
	
	
	
	// show the first card of each player and adding cards upside down if needed
	public static void showCards() {
		int playerSpecialPower = playerDeck.get(0).specialPower();
		int computerSpecialPower = computerDeck.get(0).specialPower();		
		
		String computerAddCardsLine = "";
		String playerAddCardsLine = "";

		System.out.print("AI " + computerDeck.get(0).getSecretCode());
		for (int i = 0; i < playerSpecialPower; i++) {
			System.out.print("#");
		}
		System.out.println("");
		playerAddCardsLine = "Player " + playerDeck.get(0).getcategory() + " special power added " + playerSpecialPower + " cards";
		
		System.out.print("Player " + playerDeck.get(0).getSecretCode());
		for (int i = 0; i < computerSpecialPower; i++) {
			System.out.print("#");
		}
		System.out.println("");
		computerAddCardsLine = "AI " + computerDeck.get(0).getcategory() + " special power added " + computerSpecialPower + " cards";
		
		if (computerSpecialPower != 0) {
			System.out.println(computerAddCardsLine);
		}
		if (playerSpecialPower != 0) {
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
	public static void printNumOfCards() {
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
	public static boolean playAgain() {
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