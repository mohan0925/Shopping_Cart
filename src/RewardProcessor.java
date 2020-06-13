/**This class a creates method the assignment of reward points to a customer that will create the cart
 * 
 * @author Mohan Dharavath P2519821*/



import java.util.HashSet;
import java.util.Iterator;


/**Class Start*/
public class RewardProcessor {
	
	HashSet<Product> hash_set_rewardProducts = new HashSet<Product>();
	
	boolean addProduct(Product product) {
		return hash_set_rewardProducts.add(product);
	}
	/**initializing the reward points  and defining a constructor for a customer reward points
	 * 
	 * @param cart - to add reward points for the customer for which the cart is created 
	 * @return the calculated reward points according to quantity of items for the customer
	 */
	int rewardPoints(Cart cart) {
		int points=0;
		for(Order order:cart) {
			for(Product product:hash_set_rewardProducts) {
				if(product.equals(order.getProductDetails())){
					points=points+order.getQuantity();					
				}				
			}		
		}
		cart.getCustomer().addRewardPoints(points);
		return points;
	}    
}
