/**This class creates discounted products that will be used in the cart with discount prices as a part of the shopping procedure
 * 
 * @author Mohan Dharavath P2519821*/

import java.util.Objects;
/**start of the class that is a child of the super class Product*/
public class DiscountProduct extends Product {

	private double discountRate;
	private double discountedprice;
	/**Constructor to input the product details according to the order of the arguments
	 *
	 * @param productCode for product code
	 * @param description for product description
	 * @param unitPrice for product unit price
	 * @param discountRate for product discount rate
	 */
	public DiscountProduct(String productCode, String description, int unitPrice, double discountRate) 
	{
	       super(productCode, description, unitPrice);
	       this.discountRate = discountRate;
	}
	/**method gets discount rate of product
	 * 
	 * @return product discount rate
	 */
	public double getDiscountRate() {
	    return discountRate;
	}
	/**method checks if the product is a discounted product or not
	 *
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
        final DiscountProduct discountProduct = (DiscountProduct) object;

        if (!Objects.equals(this.discountRate, discountProduct.discountRate)) 
        {
        	return false;
        }
        return true;
    }
    /**method get the unit price of product after discount
     *
     */
    @Override
	public int getUnitPrice()
	{
		double discount = discountRate * super.getUnitPrice();
		discountedprice=discount;
		return (int) Math.floor(super.getUnitPrice() -discount);
	}
    /**output in string format
     *
     */
    @Override
	public String toString() 
    {
		String output_variable=super.toString()+"\nDISCOUNT PERCENTAGE : "+discountRate+"\n"+
			"PRICE AFTER DISCOUNT : "+getUnitPrice();
		return output_variable;
	}
}
