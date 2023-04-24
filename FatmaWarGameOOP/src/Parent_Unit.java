
abstract class Parent_Unit {

	String secretCode;
	String category;
	int numOfWins;
	int numOfWinsChild;

	public Parent_Unit() {
		secretCode = "Parent";
		category = "Parent";
		numOfWins = 0;
		numOfWinsChild = 0;
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
    	return secretCode;
    }
    
    abstract public void setToZero();
    
    // abstract getter method for secretCode
    abstract public int getNumOfWins();
    
    // abstract getter method for wins of this specific Ground instance
    abstract public int getNumOfWinsChild();
    
	// getter method for category
    abstract public String getcategory();
    
	// abstract method for special power
    abstract public int specialPower();
    
	// abstract getter method for special power
    abstract public int getSpecialPowerNumber();
    
    public <T> boolean wins(T other) {
	    return false;
	}
}

