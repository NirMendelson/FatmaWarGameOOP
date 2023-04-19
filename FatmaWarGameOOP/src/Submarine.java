
public class Submarine extends Navy {

	
	public Submarine() {
		this.secretCode = "S";
	}
    
    // Override the wins() method in the parent class (Navy)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Battleship) || (other instanceof Fighter_Jet) || (other instanceof Helicopter)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance of Tank
            incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
