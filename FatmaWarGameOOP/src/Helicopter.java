
public class Helicopter extends Air {

	String secretCode = "H";
	
	public Helicopter() {
		this.secretCode = "H";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    

	public <T> boolean wins(T other) {
	    if ((other instanceof Combat_Engineering) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	System.out.println("Num of Wins of Air is " + super.getNumOfWins());
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
