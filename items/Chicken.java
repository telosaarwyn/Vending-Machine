package items;


/**
 * The Chicken class represents the chicken patty to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Chicken extends Item
{
    private static int price = 30;
    
    /**
     * The Chicken constructor sets the attributes for the "Chicken" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Chicken() {
        super(175, "Firing up the chicken patty...", true);
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
