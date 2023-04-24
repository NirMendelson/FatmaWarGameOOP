
public class Fighter_Jet extends Air {

	
	public Fighter_Jet() {
		secretCode = "F";
	}
    
    // Override the wins() method in the parent class (Air)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Helicopter) || (other instanceof Artillery) || (other instanceof Combat_Engineering)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	    	return true;
	    } else {
	        return false;
	    }
	}
	
}
