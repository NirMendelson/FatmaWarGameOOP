
public class Parent_Unit {

	String secretCode = "Parent";
	String category = "Parent";
	int numOfWins = 0;
	int numOfWinsChild = 0;

	public Parent_Unit() {
		this.secretCode = "Parent";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
    // Getter method for secretCode
    public int getNumOfWins() {
        return numOfWins;
    }
    
 // Getter method for wins of this specific Ground instance
    public int getNumOfWinsChild() {
        return numOfWinsChild;
    }
    
    public int getCategoryNumOfWins() {
    	return 0;
    }
    
	// Getter method for category
    public String getcategory() {
        return category;
    }
    
    public int specialPower() {
    	return 0;
    }
    
    public int getSpecialPowerNumber() {
    	return 0;
    }
    
    public <T> boolean wins(T other) {
	    return false;
	}

	public boolean wins() {
		// TODO Auto-generated method stub
		return false;
	}
}

