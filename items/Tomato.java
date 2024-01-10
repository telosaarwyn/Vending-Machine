package items;
/**
 * The Tomato class represents the tomatoes to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Tomato extends Item
{
    private static int price = 50;
    /**
     * The Tomato constructor sets the attributes for the "Tomato" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Tomato()
    {
        super(20, "Slicing and dicing the tomatoes...", true);
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
