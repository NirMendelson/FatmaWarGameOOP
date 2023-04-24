
public class Combat_Engineering extends Ground {

	
	public Combat_Engineering() {
		secretCode = "C";
	}

 // Override the wins() method in the parent class (Ground)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Submarine) || (other instanceof Battleship) || (other instanceof Artillery)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
