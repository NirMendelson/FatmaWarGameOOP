
public class Submarine extends Navy {

	String secretCode = "S";
	int numOfWins = 0;
	
	public Submarine() {
		this.numOfWins = 0;
		this.secretCode = "S";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Battleship) || (other instanceof Fighter_Jet) || (other instanceof Helicopter)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
