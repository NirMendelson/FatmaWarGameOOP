
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

	public <T> boolean wins(T other) {
	    if ((other instanceof Fighter_Jet) || (other instanceof Artillery)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
