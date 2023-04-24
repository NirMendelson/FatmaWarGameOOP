
public class Air extends Parent_Unit {
	
	String category = "Air";
	private static int numOfWins; // Total wins for all Ground instances
    private int numOfWinsChild; // Wins for this specific Ground instance

    // constructor
    public Air() {
    	secretCode = "Air";
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
    	if (numOfWins > 4) {
    		return 4;
    	}
    	else {
        	return numOfWins;
    	}
    }
    
    public int getSpecialPowerNumber() {
    	if (numOfWins > 4) {
    		return 4;
    	}
    	else {
        	return numOfWins;
    	}
    }


	
}
