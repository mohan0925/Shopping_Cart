/**This class creates a customer for which the cart will be created
 * 
 * @author Mohan Dharavath P2519821*/

public class Customer {
/**
 * Variables for Customer class
 */
	private String customerId;
	private Name customerName;
	private int rewardPoints;
	
	
	public Customer() {
		super();
		
	}
	/**Constructor specifies the input of name according to the arguments passed
	 * 
	 * @param customerId to get customer id
	 * @param customerName to get customer name
	 */
	public Customer(String customerId, Name customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;	
	}
	/**method to get customer id
	 * 
	 * @return returns customer id
	 */
	public String getCustomerId()
	{
		return customerId;
	}
	/**method to get customer name
	 * 
	 * @return returns customer name
	 */
	public Name getCustomerName()
	{
		return customerName;
	}
	
	/**method to get the reward points
	 * @return to get reward points for the customer
	 * */
	public int getRewardPoints() 
	{
		return rewardPoints;
	}
	
	/**
	 * @method
	 * To add reward points to the customer based on cart items 
	 * */
	public void addRewardPoints(int points) 
	{
		this.rewardPoints=this.rewardPoints+points;
	}
	
	/**
	 * To reduce points based on their uses by customer at later purchase
	 *
	 * */
	public void reduceRewardPoints(int points) 
	{
		this.rewardPoints=this.rewardPoints-points;
	}
	/**@method to get output in string format
	 */
	@Override
	public String toString() {
		String output_variable=customerId+" : "+customerName.getFullName();
		return output_variable;
	}


}
