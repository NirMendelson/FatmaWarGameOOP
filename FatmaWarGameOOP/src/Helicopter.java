
public class Helicopter extends Air {

	String secretCode = "H";
	
	public Helicopter() {
		this.secretCode = "H";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
    // Override the wins() method in the parent class (Air)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Combat_Engineering) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
