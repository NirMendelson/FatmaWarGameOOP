
public class Artillery extends Ground {

	String secretCode = "A";
	int numOfWins = 0;
	
	public Artillery() {
		this.numOfWins = 0;
		this.secretCode = "A";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Submarine)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
