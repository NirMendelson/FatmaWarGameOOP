
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
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Combat_Engineering) || (other instanceof Battleship) || (other instanceof Artillery)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
