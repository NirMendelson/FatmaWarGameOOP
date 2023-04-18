
abstract class Parent_Unit {

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
    
    // abstract getter method for secretCode
    abstract public int getNumOfWins();
    
    // abstract getter method for wins of this specific Ground instance
    abstract public int getNumOfWinsChild();
    
	// abstract getter method for category
    abstract public String getcategory();
    
	// abstract method for special power
    abstract public int specialPower();
    
	// abstract getter method for special power
    abstract public int getSpecialPowerNumber();
    
    public <T> boolean wins(T other) {
	    return false;
	}

	public boolean wins() {
		// TODO Auto-generated method stub
		return false;
	}
}

