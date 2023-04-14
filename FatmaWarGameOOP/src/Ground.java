
public class Ground extends Parent_Unit{

	String category = "Ground";
	private static int numOfWins;
	private int numOfWinsChild;
	
	public Ground() {
		numOfWinsChild = 0;
	}
	
	// Getter method for category
    public String getcategory() {
        return category;
    }
    
    // Getter method for secretCode
    public int getNumOfWins() {
        return numOfWins;
    }
    
    public int getNumOfWinsChild() {
        return numOfWinsChild; // Return wins for this instance
    }
    
    public static void incrementNumOfWins() {
        numOfWins++;
    }
    
    public void incrementNumOfWinsChild() {
        numOfWinsChild++; // Increment wins for this instance
    }
	
	public int specialPower() {
		return 1;
		
	}
	
    

}
