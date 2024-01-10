/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 */
public class Buns extends Item{
    
    private static int price = 25;

     /**
     * The Buns constructor sets the attributes for the "Buns" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Buns() {
        super(150, "Toasting the burger buns to bun-perfection...", true);
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
