
public class Air extends Parent_Unit {
	
	String category = "Air";
	private static int numOfWins; // Total wins for all Ground instances
    private int numOfWinsChild; // Wins for this specific Ground instance

    // constructor
    public Air() {
        this.secretCode = "Air";
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
    	return numOfWins;
    }
    
    public int getSpecialPowerNumber() {
    	return numOfWins;
    }


	
}
