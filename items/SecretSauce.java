package items;
/**
 * The SecretSauce class represents the Secret Sauce to be used for the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class SecretSauce extends Item
{
    private static int price = 2;
    /**
     * The SecretSauce constructor sets the attributes for the "Secret Sauce" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public SecretSauce()
    {
        super(10, "Unveiling the best-kept secret sauce...", false);
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
