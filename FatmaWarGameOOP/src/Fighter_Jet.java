
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
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Helicopter) || (other instanceof Artillery) || (other instanceof Combat_Engineering)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
