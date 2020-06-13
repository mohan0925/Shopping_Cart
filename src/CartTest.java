/**This class creates the test test program that will make the create a shopping cart with product items in an order and orders in a cart
 * and evaluate the total price and allow the addition and removal of items from the cart and converting the discounted products and 
 * applying the discount rates and printing a receipt. 
 * 
 * @author Mohan Dharavath P2519821*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Iterator;

/**Start of the Main method or test program*/
public class CartTest {

	/**passing product items to the product instance
	 * 
	 */
	static Product product1 = new Product("PN","PEN",30);
	static Product product2 = new Product("BK","BOOK",50);
	static Product product3 = new Product("BKT","BISCUIT",10);
	static Product product4 = new Product("DKP","DESKTOP",50000);
	static Product product5 = new Product("HPNS","Iball Headphones XB3424",300);
	static Product product6 = new DiscountProduct("SWT","SWEATER",150,0.15);
	static Product product7 = new DiscountProduct("CMP","Computer",3000,0.28);
	static Product product8 = new DiscountProduct("TSH","T-shirt",30,0.5);
	static Product product9 = new DiscountProduct("BNC","Binoculars",230,0.21);
	static Product product10 = new DiscountProduct("LMP","Night lamp",150,0.15);
	
	
	/**
	 * creating new cart for a new customer along with cart creation date
	 * 
	 */
	static Cart cart_orders = new Cart("Cart_Test1", new Date(13,1,2020), new Customer("MD", new Name("Mohan","Dharavath")));
	
/**calling of the use case method in main program with nesting
 * /
 * @param args validation arguments
 * @throws FileNotFoundException checks if the print writer stream exists and if not throws FNF Exception 
 */
	public static void main(String[] args) throws FileNotFoundException {
		
		UseCase1();
		UseCase2();
		UseCase3();
		UseCase4();
		UseCase5();
		UseCase6();
		
	}
/**defining the use case 1
 * create a cart and add order items to the cart and print the items and their prices 
 */
	private static void UseCase1() 
	{
		cart_orders.addOrder(new Order(2,product1));
		cart_orders.addOrder(new Order(5,product4));
		cart_orders.addOrder(new Order(4,product6));
		cart_orders.addOrder(new Order(10,product7));
		cart_orders.addOrder(new Order(3,product10)); 
		System.out.println();
	    System.out.println("=============== USECASE1 ==============================");
	    System.out.println();
	    Iterator<Order> itr=cart_orders.iterator();
		int numItems=0;
		while(itr.hasNext())
		{
			itr.next();
			numItems++;
		}
		
		System.out.println("\nCART ID : "+cart_orders.getCartId());
		System.out.println("DELIVERY DATE: "+cart_orders.getDeliveryDate().getDateString());
		System.out.println("CUSTOMER ID: "+cart_orders.getCustomer().getCustomerId());
		System.out.println("CUSTOMER NAME: "+cart_orders.getCustomer().getCustomerName().getFullName());
		  
	    System.out.println("NUMBER OF ITEMS IN CART : "+numItems);
	    System.out.println();
		cart_orders.forEach((Item) -> System.out.println(Item));
		 System.out.println();
		 System.out.println("OVERALL TOTAL PRICE : "+cart_orders.getTotalCost());
	    System.out.println("=============== END OF USECASE1 ==============================\n");
	}
		/**defining the use case 2 which needs the sorting of the cart items according to the price*/
	private static void UseCase2() 
	{
		 System.out.println("=============== USECASE2 ==============================");
			 
			System.out.println("\nCART ID : "+cart_orders.getCartId());
			System.out.println("DELIVERY DATE: "+cart_orders.getDeliveryDate().getDateString());
			System.out.println("CUSTOMER ID: "+cart_orders.getCustomer().getCustomerId());
			System.out.println("CUSTOMER NAME: "+cart_orders.getCustomer().getCustomerName().getFullName());

			System.out.println();
			System.out.println("==========CART ITEMS WITHOUT SORTING==========");
			cart_orders.forEach((Item)-> System.out.println(Item));
			System.out.println();
			System.out.println("==========CART ITEMS WITH SORTING==========");
			cart_orders.sortOrders();
			cart_orders.forEach((Item)-> System.out.println(Item));
			System.out.println();
			System.out.println("==========CART ITEMS WITH COMPARATOR SORTING==========");
						
			cart_orders.sortOrders(new Comparator<Order>() {				
				@Override
				public int compare(Order o1, Order o2) {
					int returnvalue=o1.getCost()-o2.getCost();
					if(returnvalue!=0)
					{
						return returnvalue;
					}
					returnvalue=o2.getProductDetails().compareTo(o1.getProductDetails());
					return returnvalue;
				}		
			});	
			cart_orders.forEach((order)-> System.out.println(order));
			System.out.println();
	}
/**defining the use case 3 which means the removal of an order entry and writing the cart output to a text file as a receipt*/
	private static void UseCase3() throws FileNotFoundException {
		System.out.println("=============== USECASE3 ==============================");
		System.out.println();
		cart_orders.forEach((Item)-> System.out.println(Item));
		
		Product product10 = new DiscountProduct("LMP","Night lamp",150,0.15);
		Product product11 = new Product("PNG","PEN",30);
		
		System.out.println("====================== CONTAINS ORDER TESTCASE ======================");
		System.out.println();
		System.out.println("product code ( LMP ) contains ?:"+cart_orders.containsOrder(new Order(3,product10)));
		System.out.println("product code ( PNG ) contains ?: "+cart_orders.containsOrder(new Order(3,product11)));
		System.out.println();
		System.out.println("====================== REMOVE ORDER TESTCASE ======================");
		System.out.println();
		System.out.println("Removing product code containing ( DKP )");


		cart_orders.removeOrder(new Order(5,product4));
		cart_orders.forEach((Item)-> System.out.println(Item));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
			
		  PrintWriter writer1 = new PrintWriter(new File("Cart.txt"));  
		  
		  writer1.write("CART CREATED ON DATE : "+dtf.format(now)+"\n");
		  writer1.write("\n CART ID : "+cart_orders.getCartId()+"\n");
		  writer1.write("DELIVERY DATE: "+cart_orders.getDeliveryDate().getDateString()+"\n");
		  Customer customer=cart_orders.getCustomer();
		  writer1.write("CUSTOMER ID: "+customer.getCustomerId()+"\n");
		  writer1.write("CUSTOMER NAME: "+customer.getCustomerName().getFullName()+"\n");
		  writer1.write("\n CART ORDERS:\n");	
		  cart_orders.forEach((Item)-> writer1.write(Item.toString()));
		  writer1.write("\n TOTAL : "+cart_orders.getTotalCost());
	      writer1.flush();  
	      writer1.close();  
			System.out.println("======================= ORDER LIST IS WRITTEN INTO Cart.txt ======================= \n ");
	      System.out.println("=============== USECASE3 END ==============================");	      
	}
	/**defining the use case 4: increasing and decreasing the order items quantity*/
	private static void UseCase4() 
	{
		System.out.println();
		 System.out.println("=============== USECASE4 ==============================");
		 
			System.out.println("\nCART ID : "+cart_orders.getCartId());
			System.out.println("DELIVERY DATE: "+cart_orders.getDeliveryDate().getDateString());
			System.out.println("CUSTOMER ID: "+cart_orders.getCustomer().getCustomerId());
			System.out.println("CUSTOMER NAME: "+cart_orders.getCustomer().getCustomerName().getFullName());

			System.out.println();
	      System.out.println("Get first order from cart\n");
	      Order ordercart=cart_orders.getOrder(1);
	      System.out.println();
	      System.out.println("Order Details:"+ordercart.toString());
	      System.out.println();
	      System.out.println("Increasing order quantity by 3");
	      cart_orders.increaseOrderQuantity(ordercart, 3);
	      System.out.println();
	      ordercart=cart_orders.getOrder(1);
	      System.out.println("Order Details after increase quanity:\n"+ordercart.toString());
	      System.out.println();
	      System.out.println("Decreasing order quantity by 2");
	      cart_orders.decreaseOrderQuantity(ordercart, 2);
	      System.out.println();
	      ordercart=cart_orders.getOrder(1);
	      System.out.println("Order Details after decreasing quanity:\n"+ordercart.toString());
	      
	      cart_orders.printCartDetails();
	      System.out.println();
		System.out.println("=============== USECASE4 END==============================");
	}
	/**defining the use case 5: assigning the reward points to the customer on the succesful order*/
	private static void UseCase5() 
	{
		System.out.println("=============== USECASE5 ==============================");
		System.out.println();
		RewardProcessor reward_processor=new RewardProcessor();
		 
	    // Adding order that have reward points
		reward_processor.addProduct(product6);
		reward_processor.addProduct(product7);
		reward_processor.addProduct(product10);  		
		System.out.println("Initial customer reward points : "+cart_orders.getCustomer().getRewardPoints());
		System.out.println("Calling RewardProcessor.rewardPoints() retunred : "+reward_processor.rewardPoints(cart_orders));
		System.out.println("Customer reward points : "+cart_orders.getCustomer().getRewardPoints());
		System.out.println("Again Calling RewardProcessor.rewardPoints() retunred : "+reward_processor.rewardPoints(cart_orders));
		System.out.println("Customer reward points : "+cart_orders.getCustomer().getRewardPoints());
		
		System.out.println("=============== USECASE5 END==============================");
	}
	/**defining the use case 6: appliying the price policies to the product and evaluating the prices */
	private static void UseCase6() 
	{
		System.out.println("=============== USECASE6 ==============================");
		System.out.println();
//		String policy_type="";
		
		PricePolicy Buy1_get1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				return quantity/2 * price;
			}
			
			@Override
			public String PricePolicy_type(String type) {
				return "Buy 1 Get 1 Free Price Policy";
			}
		};
		PricePolicy Buy2_get1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity/3)*(price*2);
				int fPrice2=(quantity%3)*price;
				return fPrice1 + fPrice2;
			}
			
			@Override
			public String PricePolicy_type(String type) {
				return "Buy 2 Get 1 Free Price Policy";
			}
		};
		PricePolicy Buy5_get1=new PricePolicy() {

			@Override
			public int calculateCost(int quantity, int price) {
				int fPrice1 = (quantity/6)*(price*5);
				int fPrice2=(quantity%6)*price;
				return fPrice1 + fPrice2;
			}
			
			@Override
			public String PricePolicy_type(String type) {
				return "Buy 5 Get 1 Free Price Policy";
			}
		};
		
		System.out.println("Initial cart : ");
		cart_orders.forEach((order) -> System.out.println(order));
		System.out.println("ITEMS IN THE CART :  "+cart_orders.size());
		System.out.println("TOTAL PRICE OF CART : "+cart_orders.getTotalCost());		
		System.out.println();
		System.out.println("Setting price policy...");
		System.out.println();
		System.out.println("Product prices after setting price policy");
		cart_orders.findOrder("SWT").setPricePolicy(Buy1_get1,"Buy 1 Get 1 Free Price Policy");;
		cart_orders.findOrder("LMP").setPricePolicy(Buy2_get1,"Buy 2 Get 1 Free Price Policy");
		cart_orders.findOrder("CMP").setPricePolicy(Buy5_get1,"Buy 5 Get 1 Free Price Policy");
		
		System.out.println();
		cart_orders.forEach((order) -> System.out.println(order));
		System.out.println();
		System.out.println("ITEMS IN THE CART : "+cart_orders.size());
		System.out.println("TOTAL PRICE OF CART : "+cart_orders.getTotalCost());
		System.out.println();
		System.out.println("=============== USECASE6 END==============================");
	}
}
