package items;


/**
 * The Eggs class represents the eggs to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Eggs extends Item
{
    private static int price = 7;
    /**
     * The Eggs constructor sets the attributes for the "Eggs" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Eggs() {
        super(80, "Frying sunny side up eggs...", true);
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
