
public class Fighter_Jet extends Air {

	String secretCode = "F";
	int numOfWins = 0;
	
	public Fighter_Jet() {
		this.numOfWins = 0;
		this.secretCode = "F";
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
	    if ((other instanceof Tank) || (other instanceof Helicopter) || (other instanceof Artillery) || (other instanceof Combat_Engineering)) {
	    	numOfWins++;
	    	super.numOfWins++;
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
