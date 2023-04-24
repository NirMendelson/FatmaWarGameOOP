
public class Ground extends Parent_Unit {
    
	String category = "Ground";
    private static int numOfWins; // Total wins for all Ground instances
    private int numOfWinsChild; // Wins for this specific Ground instance

    // constructor
    public Ground() {
        secretCode = "Ground";
    }
    
    // set the parameters to zero then starting a new game
    public void setToZero() {
    	numOfWins = 0;
    	numOfWinsChild = 0;
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
    	return numOfWinsChild;
    }
    
    public int getSpecialPowerNumber() {
    	return numOfWinsChild;
    }
}
