import java.util.Random;

public class Navy extends Parent_Unit {

	String category = "Navy";
	private static int numOfWins; // Total wins for all Ground instances
    private int numOfWinsChild; // Wins for this specific Ground instance
    int specialPowerNumber;
	
    public Navy() {
    	this.secretCode = "Navy";
    }
    
    
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
		int randomNumber = random.nextInt(100) + 1; // 1 to 100
		if (randomNumber <= 30) {
			specialPowerNumber = 2;
		}
		else if ((randomNumber > 30) && (randomNumber <= 50)) {
			specialPowerNumber = 1;
		}
		else {
			specialPowerNumber = 0;
		}
		return specialPowerNumber;
    }
    
    public int getSpecialPowerNumber() {
    	return specialPowerNumber;
    }


	
}
