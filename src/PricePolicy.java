/**This interface creates the price policies for a particular product to be included in the cart 
 * 
 * @author Mohan Dharavath P2519821*/

public interface PricePolicy {
	
	/**constructors to set the price policy according to the arguments  quantity and price
	 * 
	 * @param quantity quantity of the product items
	 * @param price price of the product items
	 * 
	 */
	public int calculateCost(int quantity,int price);
	
	public String PricePolicy_type(String type);
	
}
