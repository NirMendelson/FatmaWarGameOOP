public class Tank extends Ground {
	

    public Tank() {
        secretCode = "T";
    }
    
    

    // Override the wins() method in the parent class (Ground)
    @Override
    public <T> boolean wins(T other) {
        if ((other instanceof Battleship) || (other instanceof Helicopter) || (other instanceof Combat_Engineering)) {
            incrementNumOfWinsChild(); // Increment wins for this instance of Tank
            incrementNumOfWins(); // Increment total wins in Ground
            return true;
        } else {
            return false;
        }
    }
}
