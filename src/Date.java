/**This class creates a formatted date that will be used for cart creation date and delivery date
 * 
 * @author Mohan Dharavath P2519821*/

import java.text.DecimalFormat; //imports DecimalFormat class

public class Date {

	/**Variables for the date class*/
	private int day;   
    private int month;  
    private int year;
    
    /**defining the date values fixed in default
     * 
     */
    public Date() {
        day = 13;
        month = 01;
        year = 2020;
    }
    /**COnstructor for the input of date according to the arguments
     * 
     * @param day is day of the week
     * @param month is month of the year
     * @param year is the current year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** Returns a formatted date string.
     * returns date in the format dd/mm/yyyy
     * @return the formatted date as string output
     */
    public String getDateString() {
        DecimalFormat f = new DecimalFormat("00"); //used to ensure 1 outputs as 01
        return f.format(day) + "/" + f.format(month) + "/" + year;
    }
    /**override method returning the formatted date
     */
    @Override
	public boolean equals(Object obj) {
    	if (obj == null || this.getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return this.day == other.day && this.month == other.month&& this.year == other.year;
	}
}
