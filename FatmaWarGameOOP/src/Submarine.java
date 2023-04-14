
public class Submarine extends Navy {

	String secretCode = "S";
	int numOfWins = 0;
	
	public Submarine() {
		this.numOfWins = 0;
		this.secretCode = "S";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
    // Getter method for secretCode
    public int getNumOfWins() {
        return numOfWins;
    }

    public int getCategoryNumOfWins() {
    	return super.numOfWins;
    }
    
	// Getter method for category
    public String getcategory() {
        return super.category;
    }
    
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Battleship) || (other instanceof Fighter_Jet) || (other instanceof Helicopter)) {
	    	numOfWins++;
	    	super.numOfWins++;

	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
