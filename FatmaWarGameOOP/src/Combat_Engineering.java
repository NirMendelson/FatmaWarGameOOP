
public class Combat_Engineering extends Ground {

	String secretCode = "C";
	
	public Combat_Engineering() {
		this.secretCode = "C";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }

 // Override the wins() method in the parent class (Ground)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Submarine) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	System.out.println("Num of Wins of Ground is " + super.getNumOfWins());
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
