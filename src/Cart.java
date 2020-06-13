/**This class creates a list for the cart to be executed including the Order items and product items
 * methods described here are called in the test program 
 * 
 * @author Mohan Dharavath P2519821*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**Start of the cart Class*/
public class Cart implements Iterable<Order>{
	
	private String cart_Id; 		/**variable to assign the cart id*/
	private Customer customer;		/**variable to assign customer object reference*/
	private Date deliveryDate;		/**variable to assign date object reference*/	
	
	/**
	 * Creating instance for Array List
	 */
	private List<Order> productOrders=new ArrayList<>();	
	
	/**Custom Constructor used to assign the values to the variables
	 * 
	 * @param cartId to assign the cart id
	 * @param deliveryDate  to assign the date
	 * @param customer  to assign the customer
	 */
	public Cart(String cartId, Date deliveryDate, Customer customer) {
		super();
		this.cart_Id = cartId;
		this.deliveryDate = deliveryDate;
		this.customer = customer;
		
	}
	/**
	 * methods for the cart class
	 */

	public Cart() {
		super();
	}
	
	/**
	 * method adds an order to the cart
	 * @param order creates and instance of order to add an order according to specified parameters in order class constructor
	 */
    public void addOrder(Order order) {
        this.productOrders.add(order);
    }
	/**
	 * method removes an order to the cart
	 * @param order creates and instance of order to remove an order according to specified parameters in order class constructor
	 */
    public void removeOrder(Order order) {
    	productOrders.remove(order);
    }
    /**methods for getting total cost of the cart class
     * 
     * @return returns total cost of an order
     */
	public int getTotalCost()
	{
		int total=0;
		for(Order order:productOrders)
			total+=order.getCost();
		return total;
	}
	/**methods for checking contain order in the cart class
	 * 
	 * @param parameterised check of an order if exists in the order by initialising an order class instance
	 * @return boolean value false if the item queried is not equal to the order placed
	 */
	public boolean containsOrder(Order order)
	{
		for(Order item : productOrders)
		{
			if(item.equals(order))
			{
			return true;
			}
		}return false;
	}
	/**methods for finding an order in the cart class
	 * 
	 * @param productCode searches for a particular product code
	 * @return order details according to the query via product code
	 */
	public Order findOrder(String productCode)
	{
		for(Order order : productOrders)
		{
			if(order.getProductDetails().getproductcode().compareTo(productCode)==0)
				return order;
		}
		return null;
	}
	/**methods for sorting items in the cart class
	 *
	 */
    public void sortOrders()
	{
		Collections.sort(productOrders);
	}
    /**methods for the comparator and sort cart class
     *
     * @param comparator interface as parameter to sort order list according to the method in the interface 
     */
	public void sortOrders(Comparator<Order> comparator)
	{
		Collections.sort(productOrders,comparator);	
	}
	/**methods to get cart id of the cart class
	 * 
	 * @return the cart id of the cart
	 */
	public String getCartId()
	{
		return cart_Id;
	}
	/**methods to get the delivery date
	 * 
	 * @return the delivery date of the cart orders
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	/**methods to get the customer for the cart class
	 * 
	 * @return customer details for which the cart is created
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**methods to get the cart size
	 * 
	 * @return the size of the order list
	 */
	public int size() {
		return productOrders.size();
	}
	
	/**
	 * 
	 * @param order increasing the order by static call to the variable in order class
	 * @param qty variable for the quantity increased
	 * @return boolean value true if the increase is successful
	 */
	public boolean increaseOrderQuantity(Order order,int qty) {
		Iterator<Order> iterator=productOrders.iterator();
		
		while(iterator.hasNext()) {
			
			if(order.equals(iterator.next())) {
				
				order.increaseQuanitity(qty);
				return true;
			}
		}
		return false;	
	}
	
	/**
	 * 
	 * @param order decreasing  the order by static call to the variable in order class
	 * @param qty variable for the quantity increased
	 * @return boolean value true if the decrease is successful
	 */
	public boolean decreaseOrderQuantity(Order order,int qty) {
		Iterator<Order> it=productOrders.iterator();
		while(it.hasNext()) {			
			if(order.equals(it.next())) {
				order.decreaseQuanitity(qty);
				return true;
			}
		}
		return false;
	}
	

	 /**
	  * method to get the product id according to the index value
	  * @param id index value of a particular order
	  * @return return the product id that matches the index value input
	  */
	public Order getOrder(int id) {
		if(id>productOrders.size()) {
			System.out.println("Wrong id, enter number between 1-"+productOrders.size());
			return null;
		}else {
			return productOrders.get(id-1);
		}
	}
	
	/**
	 * method to Print cart details to the console
	 * */
	public void printCartDetails() {
		System.out.println("CART ID : "+this.cart_Id);
		System.out.println("DELIVERY DATE: "+this.deliveryDate.getDateString());
		System.out.println("CUSTOMER ID: "+this.customer.getCustomerId());
		System.out.println("CUSTOMER NAME: "+this.customer.getCustomerName().getFullName());
		System.out.println("\n CART ORDERS:\n");
		Iterator<Order> it=productOrders.iterator();
		int c=1;
		while(it.hasNext()) {
			System.out.println(c+")"+it.next().toString());
			c++;
		}
	}
	/**methods for the iteration of cart class
	 *@return the order list
	 */
	@Override
	public Iterator<Order> iterator() {
		 return productOrders.iterator();
	}
	/**methods for data type conversion of the cart class
	 *@return the string format of output variable
	 */
	@Override
	public String toString() {
		String output_variable= cart_Id + " : !!! "+deliveryDate.getDateString()+" !!! : "+customer.toString();
		return output_variable;
	}
}
