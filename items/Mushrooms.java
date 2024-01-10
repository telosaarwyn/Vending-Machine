package items;

/**
 * The Mushrooms class represents the mushrooms to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Mushrooms extends Item
{
    private static int price = 12;
    /**
     * The Mushrooms constructor sets the attributes for the "Mushrooms" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Mushrooms()
    {
        super(15, "Sauteing the mushrooms...", true);
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
