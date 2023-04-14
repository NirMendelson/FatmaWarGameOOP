
public class Combat_Engineering extends Ground {

	String secretCode = "C";
	int numOfWins = 0;
	
	public Combat_Engineering() {
		this.numOfWins = 0;
		this.secretCode = "C";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Submarine) || (other instanceof Battleship) || (other instanceof Artillery)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
