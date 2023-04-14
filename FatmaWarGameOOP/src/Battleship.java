
public class Battleship extends Navy {

	String secretCode = "Battleship";
	int numOfWins = 0;
	
	public Battleship() {
		this.numOfWins = 0;
		this.secretCode = "B";
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
	    if ((other instanceof Fighter_Jet) || (other instanceof Artillery)) {
	    	numOfWins++;
	    	super.numOfWins++;
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
