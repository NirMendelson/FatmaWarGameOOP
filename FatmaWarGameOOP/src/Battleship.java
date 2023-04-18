
public class Battleship extends Navy {

	String secretCode = "Battleship";
	
	public Battleship() {
		this.secretCode = "B";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
    // Override the wins() method in the parent class (Navy)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Fighter_Jet) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance of Tank
            incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
