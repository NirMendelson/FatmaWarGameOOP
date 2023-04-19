
public class Battleship extends Navy {

	
	public Battleship() {
		this.secretCode = "B";
	}
    
    // Override the wins() method in the parent class (Navy)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Fighter_Jet) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance of Tank
            incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
