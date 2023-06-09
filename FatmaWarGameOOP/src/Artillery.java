
public class Artillery extends Ground {

	
	public Artillery() {
		secretCode = "A";
	}
    
 // Override the wins() method in the parent class (Ground)
    @Override
	public <T> boolean wins(T other) {
	    if ((other instanceof Tank) || (other instanceof Submarine)) {
	    	incrementNumOfWinsChild(); // Increment wins for this instance
	        incrementNumOfWins(); // Increment total wins in Ground
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
