
package items;

/**
 * The Plant class represents the plant-based patty to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Plant extends Item
{
    private static int price = 70;
    /**
     * The Plant constructor sets the attributes for the "Plant" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Plant()
    {
        super(200, "Firing up the plant-based patty...", true);
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
