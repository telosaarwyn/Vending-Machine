package items;

/**
 * The Pickles class represents the pickles to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Pickles extends Item
{
    private static int price = 1;
    
    /**
     * The Pickles constructor sets the attributes for the "Pickles" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Pickles()
    {
        super(15, "Relishing to pickle perfection…...", true);
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
