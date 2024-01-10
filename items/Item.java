package items;

/**
 * The Item class constructs the main items for the vending machine. It includes the
 * getters and setters for these items in the ItemList.
 * 
 * @author Lim, Theoni Anne
 *         Telosa, Arwyn Gabrielle
 * @version 2.0
 * @since 07-18-2023
 */
public class Item
{
    private int price;

    protected float calories;
    protected String message;
    protected boolean standAlone;
    
    /**
     * The Item constructor method sets the name, price, and calories of an item.
     * @param calories stores how much calories are in an item
     * @param message the preparation message for a specific item
     * @param standAlone determines whether the item can be sold as itself or not
     */
    public Item(float calories, String message, boolean standAlone)
    {
        //initializes the name, price, and calories of an item
        this.calories = calories;
        this.message = message;
        this.standAlone = standAlone;
    }
    
    /**
     * The getCalories method gets the calories of a specific item.
     * @return calories of the item
     */
    public float getCalories()
    {
        return this.calories;
    }

    /**
     * The getPrice method retrieves the price of the item.
     */
    public int getPrice(){
       return this.price;
    }

    /**
     * The setPrice method sets the new price of this item.
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * The getMessageString gets the message to be displayed for the item.
     * @return the preparation message for the item
     */
    public String getMessage()
    {
        return this.message;
    }

    /**
     * The getStandAlone returns true if the item can be sold as itself, false if not
     * @return true or false
     */
    public boolean getStandAlone()
    {
        return this.standAlone;
    }
    
    @Override 
    /**
     * The toString method returns the simple name of the class for the current instance.
     */
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
