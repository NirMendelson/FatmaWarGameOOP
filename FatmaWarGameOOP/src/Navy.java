import java.util.Random;

public class Navy extends Parent_Unit {

	String category = "Navy";
	private static int numOfWins; // Total wins for all Ground instances
    private int numOfWinsChild; // Wins for this specific Ground instance
    int specialPowerNumber;
	
	// Getter method for category
    public String getcategory() {
        return category;
    }

    // Getter method for total wins of Ground
    public int getNumOfWins() {
        return numOfWins;
    }

    // Getter method for wins of this specific Ground instance
    public int getNumOfWinsChild() {
        return numOfWinsChild;
    }

    // Increment total wins of Ground
    public static void incrementNumOfWins() {
        numOfWins++;
    }

    // Increment wins of this specific Ground instance
    public void incrementNumOfWinsChild() {
        numOfWinsChild++;
    }
    
    public int specialPower() {
    	Random random = new Random();
		int specialPowerNumber = random.nextInt(100) + 1; // 1 to 100
		if (specialPowerNumber <= 30) {
			return 2;
		}
		else if ((specialPowerNumber > 30) && (specialPowerNumber <= 50)) {
			return 1;
		}
		else {
			return 0;
		}
    }
    
    public int getSpecialPowerNumber() {
    	return specialPowerNumber;
    }

    // Override the wins() method in the parent class (Parent_Unit)
    @Override
    public boolean wins() {
        incrementNumOfWins(); // Increment total wins of Ground
        incrementNumOfWinsChild(); // Increment wins of this specific Ground instance
        return true; // or false, depending on win logic
    }
	
}
