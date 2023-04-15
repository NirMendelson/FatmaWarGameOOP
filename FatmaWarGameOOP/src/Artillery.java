
public class Artillery extends Ground {

	String secretCode = "A";
	
	public Artillery() {
		this.secretCode = "A";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
 // Override the wins() method in the parent class (Ground)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Submarine)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	System.out.println("Num of Wins of Ground is " + super.getNumOfWins());
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
