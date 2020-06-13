/**This class a product item with description and unit price and the methods to get the methods for the product items that will be
 * included in the order in the cart.
 * 
 * @author Mohan Dharavath P2519821*/



import java.util.Objects;
/**
 * implementing the comparable interface*/
public class Product implements Comparable<Product>{

	/*variables*/
	private String productCode;
    private String description;
    protected int unitPrice;
    /**
     * method gets product unit price
     * @return return product unit price
     * 
     * */
    public int getUnitPrice()
	{
		return this.unitPrice;
	}
    /**
     * method gets product code
     * @return return product code
     * */
    public String getproductcode()
	{
		return this.productCode;
	}
    /**method gets product description
     * @return return product description
     */
	public String getproductdescription()
	{
		return this.description;
	}
    /**constructor to initialize a product as passed arguments to an instance of the class
	/**
	 * 
	 * @param productCode for product code
	 * @param description for product description
	 * @param unitPrice for product unit price
	 */
    public Product(String productCode, String description, int unitPrice) {
    	super();
        this.productCode = productCode;
        this.description = description;
        this.unitPrice = unitPrice;
    }
    /**compare product with product in cart
     *
     * @return if the product exsists in the cart or not
     */
	@Override
	public int compareTo(Product p) {
		int compare = this.productCode.compareTo(p.productCode);
		
        if (compare == 0)
        {
        	compare = this.description.compareTo(p.description);
        }
        if (compare == 0)
        {
        	compare = (this.unitPrice > p.unitPrice) ? 1 : this.unitPrice < p.unitPrice ? -1 : 0;
        }
        	
        return compare;
	}
	/**
	 * check if a product exists in the cart
	 *
	 * @return
	 */
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

	        final Product product = (Product) object;

	        if (!Objects.equals(this.productCode, product.productCode))
	        	{
	        		return false;
	        	}
	        if (!Objects.equals(this.unitPrice, product.unitPrice))
	        	{
	        		return false;
	        	}
	        if (!Objects.equals(this.description, product.description))
	        	{
	        		return false;
	        	}

	        return true;
	    }
	 /**output type in string format
	  * @return the formatted string output
	  * */
		@Override
		public String toString() {
			String output_variable="Product Code	: " +productCode+"\ndescription	: " +description+"\nUnit Price	: "+unitPrice;
			return output_variable;
		}

}
