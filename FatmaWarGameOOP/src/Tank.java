
public class Tank extends Ground {

	String secretCode = "T";
	private int numOfWinsChild;
	
	public Tank() {
		this.secretCode = "T";
		numOfWinsChild = 0;
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
 // Method to increment wins for this child class (Tank)
    public void incrementNumOfWinsChild() {
        numOfWinsChild++;
    }
    
	
	public <T> boolean wins(T other) {
	    if ((other instanceof Battleship) || (other instanceof Helicopter) || (other instanceof Combat_Engineering)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	System.out.println("Num of Wins of Ground is " + super.getNumOfWins());
	        return true;
	    } else {
	        return false;
	    }
	}


}
	

