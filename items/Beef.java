package items;

/**
 * The Beef class represents the beef patty to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Beef extends Item
{
    private static int price = 50;

     /**
     * The Beef constructor sets the attributes for the "Beef" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Beef() {
        super(250, "Firing up the beef patty...", true);
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
