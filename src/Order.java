/**This class creates an order for the shopping cart which will contain the product items, quantity and the total price
 * 
 * @author Mohan Dharavath P2519821*/

import java.util.Objects;

/**implementation of interface for comparing products and orders*/
public class Order implements Comparable<Order>{
/**variables for the order class*/
	private int quantity;
	private Product product;
	private PricePolicy policy;
	private String policy_type;
	/**constructor*/
	/** passing of order quantity and product instance to be added to an order
	 * 
	 * @param quantity specifies item quantity
	 * @param product specifies an instance of the product class providing product details
	 */
	public Order(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.policy = new PricePolicy() {
/**
 * 
 */
			@Override
			public int calculateCost(int quantity, int price) {
				return quantity * price;
			}
			
			@Override
			public String PricePolicy_type(String type) {
				return policy_type;
			}
		};
		
	}
	/**
	 * method returns the total cost of an order item
	 * @return the calculated cost after applying price policy
	 */
	public int getCost()
	{
		return policy.calculateCost(quantity, product.getUnitPrice());
	}
    
	/**
	 * method to increase the Purchase quantity of a product
	 * @param qty increase the quantity of the item
	 */
	public void increaseQuanitity(int qty) {
		this.quantity=this.quantity+qty;
	}
	/**
	 * method to decrease the Purchase quantity of a product
	 * @param qty to decrease the item quantity
	 */
	public void decreaseQuanitity(int qty) {
		this.quantity=this.quantity-qty;
	}
/**
 * method to get the total quantity of a product
 * @return the current quantity of the product item
 */
    public int getQuantity() {
    	return this.quantity;
	}
	/**
	 * method to get the details of a product
	 * @return a particular product in the order
	 */
	public Product getProductDetails() {	
		return this.product;
	}
	/**
	 * method to set the price policy for a product
	 * @param pricePolicy instance of price policy defined in th eprice policy class
	 * @param policy_type defined the type of price poicy
	 */
	public void setPricePolicy(PricePolicy pricePolicy,String policy_type) {
		this.policy = pricePolicy;
		this.policy_type=policy_type;
	}

	/**
	 * method to output in string format
	 * */
	@Override
	public String toString() {
		String output_variable=product.toString()+"\nQUANTITY	:" + this.quantity + "\n" + 
				"PRICE POLICY	: " + this.policy_type + "\n" +
				"TOTAL PRICE	: "+ getCost()+"\n";
		return output_variable;
	}
	/**compare method for wuantity of an item*/
	@Override
	public int compareTo(Order o) {
		  return (this.getQuantity() > o.getQuantity()) ? 1 : this.getQuantity() < o.getQuantity() ? -1 : 0;
	}
	/**method returns if an item exist in the cart*/
	@Override
    public boolean equals(Object object) {
        if (this == object) 
        {
        	return true;
        }
        if (object == null) 
        {
        	return false;
        }
        if (getClass() != object.getClass()) 
        {
        	return false;
        }
        final Order order = (Order) object;

        if (!Objects.equals(this.getQuantity(), order.getQuantity())) {
        	return false;
        }
        if (!this.getProductDetails().equals(order.getProductDetails())) {
        	return false;
        }

        return true;
    }



}
