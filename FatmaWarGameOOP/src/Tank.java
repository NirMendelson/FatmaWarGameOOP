
public class Tank extends Ground {

	String secretCode = "T";
	int numOfWins = 0;
	
	public Tank() {
		this.numOfWins = 0;
		this.secretCode = "T";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Battleship) || (other instanceof Helicopter) || (other instanceof Combat_Engineering)) {
	        return true;
	    } else {
	        return false;
	    }
	}


}
	

