
public class Parent_Unit {

	String secretCode = "Parent";
	String category = "Parent";


	public Parent_Unit() {
		this.secretCode = "Parent";
	}
	
	// Getter method for secretCode
    public String getSecretCode() {
        return secretCode;
    }
    
	
	// Getter method for category
    public String getcategory() {
        return category;
    }
    
    public <T> boolean wins(T other) {
	    return false;
	}
}

