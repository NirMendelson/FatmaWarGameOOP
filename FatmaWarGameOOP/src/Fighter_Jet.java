
public class Fighter_Jet extends Air {

	String secretCode = "F";
	
	public Fighter_Jet() {
		this.secretCode = "F";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
    // Override the wins() method in the parent class (Air)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Helicopter) || (other instanceof Artillery) || (other instanceof Combat_Engineering)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
