
public class Air extends Parent_Unit {
	
	String category = "Air";
	int numOfWins = 0;

	
	// Getter method for category
    public String getcategory() {
        return category;
    }

    // Getter method for secretCode
    public int getNumOfWins() {
        return numOfWins;
    }
    
	public int specialPower() {
		return 1;
		
	}
	
}
