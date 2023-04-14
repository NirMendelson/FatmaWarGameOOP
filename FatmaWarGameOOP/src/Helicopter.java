
public class Helicopter extends Air {

	String secretCode = "H";
	int numOfWins = 0;
	
	public Helicopter() {
		this.numOfWins = 0;
		this.secretCode = "H";
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
	    if ((other instanceof Combat_Engineering) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	numOfWins++;
	    	super.numOfWins++;
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
