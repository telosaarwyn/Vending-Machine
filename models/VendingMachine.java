package models;

import items.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * The VendingMachine class includes all the methods for the vending and maintenance features.
 * All the working test features are included in this class.
 * 
 * @author Lim, Theoni Anne
 *         Telosa, Arwyn Gabrielle
 * @version 1.0
 * @since 06-02-23 
 */

public class VendingMachine
{
    public final static int[] denominations = {1, 5, 10, 20, 50, 100, 200, 500, 1000};                /** Vending Machine attributes */
    protected TreeMap<String, ArrayList<Item>> items = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private int[] cashInStorage = new int[9];
    private int totalPayment;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    protected Item itemToDispense = null;
    
    public TreeMap<String, ArrayList<Item>> getItems(){
        return items;
    }
    

    

    // vending features
    /**
     * The addProduct method adds the item from the user's input in the ArrayList.
     * @param item to be possibly added to the item list
     * @return  true if product was successfully added, false if product already exists
     */
    public boolean addProduct(Item item)                        
    {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 11; i++)                            
        {
            // adds item, if not yet existing
            items.add(item);
        }
        this.items.put(item.getClass().getSimpleName(), items);
        return true;
    }
    
    /**
     * The receivePayment method allows users to use different denominations in pesos for payment in
     * the vending machine.
     */
    public void receivePayment(int[] payment, int totalPayment)
    {
        for (int i = 0; i < payment.length; i++)
            cashInStorage[i] += payment[i];
        
        this.totalPayment = totalPayment;
    }

    /**
     * The selectItem method allows users to select the items from the ArrayList of items.
     */
    public boolean selectItem(Item item)
    {
        itemToDispense = null;

        if (this.items.get(item.getClass().getSimpleName()).size() > 1)
        {
            this.itemToDispense = this.items.get(item.getClass().getSimpleName()).get(0);
            return true;
        }
        return false;
    }

    /**
     * The produceChange method gives back the change, if ever there is any, to the user upon selecting an item.
     * If an item is selected, yet the payment is not enough, the payment is dispensed as change.
     * If the vending machine lacks the needed change, it does not transact with the user, no item will be dispensed.
     * If the user backs out from selecting an item, the initial payment is produced as change.
     * @return change in denominations if successful. if unsuccessful, value at index 0 represents error message
     * -1 = insufficient payment
     * -2 = insufficient change
     */
    public int[] produceChange()
    {
        int[] change = new int[9];


        /* if totalPayment is insufficient, returns the initial payment */
        if (totalPayment < itemToDispense.getPrice())
        {
            itemToDispense = null;
            change[0] = -1;
            return change;
        }

        /* computes for the change needed */
        int changeNeeded = totalPayment - itemToDispense.getPrice();
        for (int i = denominations.length-1; i >= 0; i--)
        {
            while (cashInStorage[i] > 0 && denominations[i] <= changeNeeded)
            {
                change[i]++;
                cashInStorage[i]--;
                changeNeeded -= denominations[i];
            }
        }

        /* if vending machine does not have enough change, then no transaction is made */
        if (changeNeeded != 0)
        {
            itemToDispense = null;
            for (int i = 0; i < change.length; i++)
            {
                while (change[i] > 0)
                {
                    change[i]--;
                    cashInStorage[i]++;
                }
            }
            change[0] = -2;
            return change;
        }

        /* dispenses the change in denominations */
        return change;

    }

    /**
     * The dispenseItem method produces the item that the user was able to buy from the vending machine.
     * If there is no item to dispense, then the returnPayment method is called.
     */
    public String dispenseItem()
    {
        items.get(itemToDispense.getClass().getSimpleName()).remove(0);
        Transaction transaction = new Transaction(itemToDispense.getClass().getSimpleName(), itemToDispense.getPrice());            /* creates a new transaction of this item */
        this.transactions.add(transaction);                                                                        /* adds it to the transaction list */
        String itemName = itemToDispense.getClass().getSimpleName();
        itemToDispense = null;
        return itemName;
    }

    /**
     * The returnPayment method is only accessible by the dispenseItem. It returns the initial payment of the user
     * once the method is called as there is no item to dispense.
     */
    public String[] returnPayment(){
        String[] payment = new String[denominations.length];
        
        /* goes through denomination and checks if there is enough denominations/payments available */
        for (int i = this.cashInStorage.length-1; i >= 0; i--)
        {
            int count = 0;
            while (cashInStorage[i] > 0 && denominations[i] <= totalPayment)
            {
                totalPayment -= denominations[i];
                cashInStorage[i]--;
                count++;
            }
            payment[i] = "[" + count + "x] P" + denominations[i];
        }
        return payment;
    }


    // maintenance features

    /**
     * The stock method allows users to restock a specific item when it is low in stock.
     * It adds 10 more stocks to the item.
     */
    public void stock(Item item)
    {
        /* adds 10 more stocks to the item selected */
        for (int i = this.items.get(item.getClass().getSimpleName()).size(); i < 11; i++)
        {
            this.items.get(item.getClass().getSimpleName()).add(item);
        }

        /* transactions are cleared from the last restock */
        transactions.clear();
    }
    
      /**
     * The setPrice method allows users to change the initial price of an item.
     */
    public void setPrice(String itemName, int price)
    {
        items.get(itemName).get(0).setPrice(price);
    }
    

    /**
     * The collectPayment method allows users to collect all the payments made by the vending machine.
     */
    public int[] collectPayment()
    {
        int[] totalCash = new int[cashInStorage.length];
        /* collects the total payments from the vending machine */
        for (int i = 0; i < cashInStorage.length; i++)
        {
            totalCash[i] = cashInStorage[i];                      // copy values 
            cashInStorage[i] = 0;                                 /* sets cashInStorage to 0 as all cash has been collected */
        }
        return totalCash;

    }

    /**
     * The replenishMoney method lets users add money from the collected payment for the vending machine
     * to be able to produce change.
     */
    public void replenishMoney(int[] denoms)
    {
        for (int i = 0; i < cashInStorage.length; i++){
            cashInStorage[i] += denoms[i];
        }
    }

    /**
     * The getTransactions method retrives the liast of transactions recorded in the vending machine.
     * 
     * @return transactions - list containing all the recorded transactions
     */
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }
    
    /**
     * The removeItem method removes the first occurence of an item from the inventory.
     * 
     * @return itemName - item to be removed from the inventory
     */
    public void removeItem(String itemName){
        items.get(itemName).remove(0);
    }

    /**
     * The addTransaction method adds a new transaction to the list of recorded transactions.
     * 
     * @param t - represents the transactions to be added
     */
    public void addTransaction(Transaction t){
        transactions.add(t);
    }
    
}
