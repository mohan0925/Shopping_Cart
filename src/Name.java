/**This class creates a name assigning standard for the customer for whom the cart will be created
 * 
 * @author Mohan Dharavath P2519821*/
public class Name {
	/**variable of name class*/
	private String firstName;
	private String familyName;
	/**constructor*/
	/** input of the name according to the associated parameters
	 * 
	 * @param firstName specifies first name 
	 * @param familyName specifies last name
	 */
	public Name(String firstName, String familyName) {
		super();
		this.firstName = firstName;
		this.familyName = familyName;
	}
	/**default constructor*/
	/**
	 * 
	 */
	public Name() {
		this.firstName = "";
		this.familyName = "";
	}
/**
 * method gets full name
 * @return full name*/
	public String getFullName()
	{
		return this.firstName+" "+this.familyName;
	}	
}
