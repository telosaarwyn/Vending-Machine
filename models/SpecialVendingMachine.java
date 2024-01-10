package models;

import items.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * The SpecialVendingMachine class includes all the methods for the special vending features.
 * 
 * @author Lim, Theoni Anne
 *         Telosa, Arwyn Gabrielle
 * @version 1.0
 * @since 07-21-23 
 */
public class SpecialVendingMachine extends VendingMachine {
    
    
    private HashMap<String, Integer> selectedPatties = new HashMap<>();        
    private HashMap<String, Integer> selectedToppings = new HashMap<>();

    /** 
     * The getPatties retrieves a list of patties from the items stored in the inventory.
     * @return ArrayList of available patties - is a list containing the patties beef, plant, and chicken that are present in the inventory.
     */
     public ArrayList<Item> getPatties(){
        ArrayList<Item> patties = new ArrayList<>();
         
        for (String itemName : items.keySet()){
             if (itemName.equals("Beef")|| itemName.equals("Plant") || itemName.equals("Chicken")){
                 if (items.get(itemName).size()-1 > 0)
                    patties.add(items.get(itemName).get(0));
            }
        }
        return patties;
     }
     
     /**
      * The pattiesIsEmpty checks if there are any patties available in the items stored in the inventory.
      * @return boolean - true if no patties are present, false if there are patties in the inventory.
      */
    public boolean pattiesIsEmpty(){
         for (String itemName : items.keySet()){
             if (itemName.equals("Beef")|| itemName.equals("Plant") || itemName.equals("Chicken")){
                 if (items.get(itemName).size()-1 > 0)
                     return false;
             }
         }
         return true;
    }
      
    /**
     * The bunsIsEmpty checks if there are any patties available in the items stored in the inventory.
     * @return boolean - true if no buns are present, false if there are buns in the inventory.
     */
    public boolean bunsIsEmpty(){
         if (items.get("Buns").size()-1 == 0){
             return true;
        } else
             return false;
    }
     
    /**
     * The addPatty method adds a specific quantity of a patty to the selectedPatties.
     * @param patty type of patty to be added
     * @param quantity number of patties to be added
     */
    public void addPatty(String patty){        
        if (!selectedPatties.containsKey(patty)) {
            selectedPatties.put(patty, 1);
        } else {
            throw new IncompleteBurgerException("You can only select one type of patty.");
        }
    }

    /**
     * The clearPatties method removes the selected patty from selectedPatties 
     */
    public void clearPatties(){
        selectedPatties.clear();
    }
     
    /**
     * The selectTopping method adds a specific quantity of a toppings to the selectedToppings.
     * @param itemName type of topping to be added
     * @param quantity number of toppings to be added
     */
    public void selectTopping(String itemName, int quantity){
        selectedToppings.put(itemName, quantity);
    }

    /**
     * The getSelectedPatties method retrieves the inventory of selected patties.
     * @return selectedPatties - contains the selected patties and their corresponding quantities.
     */
    public HashMap<String, Integer> getSelectedPatties(){
         return selectedPatties;
     }
     
    /**
     * The getSelectedToppings method retrieves the inventory of selected toppings.
     * @return selectedToppings - contains the selected toppings and their corresponding quantities.
     */
    public HashMap<String, Integer> getSelectedToppings(){
         return selectedToppings;
     }
 
    /**
     * The setItemToDispense method sets the custom item to be dispensed based on the selected patties and toppings.
     */
    public void setItemToDispense(){
         
        float calories = 0;
        int price = 0;

        for (String patty : getSelectedPatties().keySet()){
            int quantity = getSelectedPatties().get(patty);
            calories += getItems().get(patty).get(0).getCalories() * quantity;
            price += getItems().get(patty).get(0).getPrice() * quantity;
        }
         
        calories += items.get("Buns").get(0).getCalories();
        price += items.get("Buns").get(0).getPrice();
         
        for (String itemName : getSelectedToppings().keySet()){
            int quantity = getSelectedToppings().get(itemName);
            calories += getItems().get(itemName).get(0).getCalories() * quantity;
            price += getItems().get(itemName).get(0).getPrice() * quantity;
        }
         
        Item custom = new Item(calories, "", true);
        custom.setPrice(price);
        this.itemToDispense = custom;
     }
    
    /**
     * The clearTray method clears the current selection of patties and toppings from the tray.
     */
    public void clearTray(){
         selectedPatties.clear();
         selectedToppings.clear();
    }
     
    /**
     * The dispenseItems method dispenses a custom burger and updates the inventory and transaction history.
     */
    public void dispenseItems(){

         if (selectedPatties.isEmpty())        // at least 1 patty should be selected
             throw new IncompleteBurgerException("Please choose at least one (1) patty for your burger.");

         if (bunsIsEmpty())
             throw new IncompleteBurgerException("Burger Buns are mandatory for the special vending machine.");
         
         // remove items from the inventory
         for (String patty : selectedPatties.keySet()) {
            super.removeItem(patty);
        }
         
         super.removeItem("Buns");
         
         for (String toppingName : selectedToppings.keySet()){
             for (int i = 0; i < selectedToppings.get(toppingName); i++){
                 super.removeItem(toppingName);
             }
         }
         clearTray();
         
         // add transaction
         Transaction t = new Transaction("Custom Burger", itemToDispense.getPrice());
         super.addTransaction(t); 
    }
    
    /**
     * The IncompleteBurgerException class represents an incomplete burger if there is no bun or patty present in the inventory.
     * @see RuntimeException
     */
    class IncompleteBurgerException extends RuntimeException
    {
        /**
         * The IncompleteBurgerException method constructs a new exception with the specified error message.
         * @param message - the error message describing the incomplete burger
         * @see IncompleteBurgerException
         * @see RuntimeException
         */
        public IncompleteBurgerException(String message)
        {
            super(message);
        }
    }
}
