
public class Submarine extends Navy {

	String secretCode = "S";
	
	public Submarine() {
		this.secretCode = "S";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
   
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Battleship) || (other instanceof Fighter_Jet) || (other instanceof Helicopter)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance of Tank
            incrementNumOfWins(); // Increment total wins in Ground
//            System.out.println("Num of Wins of Ground is " + super.getNumOfWins());
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
