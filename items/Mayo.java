package items;

/**
 * The Mayo class represents the mayo to be added to the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Mayo extends Item
{
    private static int price = 3;
    /**
     * The Mayo constructor sets the attributes for the "Mayo" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Mayo()
    {
        super(10, "Mixing the oil and egg white...", false);
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
