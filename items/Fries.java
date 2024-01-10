package items;


/**
 * The Fries class represents the fries to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Fries extends Item
{
    private static int price = 80;
    
    /**
     * The Fries constructor sets the attributes for the "Fries" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Fries()
    {
        super(250, "Seasoning the fries to golden greatness...", true);
    }
    
    @Override
    /**
     * The getPrice method retrieves the price of the item.
     */
    public int getPrice() {
        return this.price;
    }
    
    @Override
    /**
     * The setPrice method sets the new price of this item.
     */
    public void setPrice(int price) {
        this.price = price;
    } 
    
}
