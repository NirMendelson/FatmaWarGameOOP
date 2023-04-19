
public class Helicopter extends Air {

	
	public Helicopter() {
		this.secretCode = "H";
	}
    
    // Override the wins() method in the parent class (Air)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Combat_Engineering) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
