package frames;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import models.VendingMachine;

/**
 * The SelectItemFrame Class represents the GUI for choosing item in regular vending machine
 *
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class SelectItemFrame extends javax.swing.JFrame {

    private VendingMachine vendingMachine = null;
    private MainFrame sourceFrame = null;
    
    /**
     * The SelectItemFrame constructs a SelectItemFrame
     *
     * @param sourceFrame reference to main frame
     * @param vendingMachine instance of current vending machine
     */
    public SelectItemFrame(MainFrame sourceFrame, VendingMachine vendingMachine) {
        this.sourceFrame = sourceFrame;
        this.vendingMachine = vendingMachine;
        initComponents();
        displayItems();
    }
    
    /**
     * Displays items available in the vending machine on the UI.
     */
    private void displayItems(){
        
        for (String itemName : vendingMachine.getItems().keySet()){
            JPanel subPanel = new JPanel();
            subPanel.setLayout(new GridLayout(5, 1, 2, 2));
            
            JLabel nameLbl = new JLabel(itemName);
            nameLbl.setFont(new Font("Arial", Font.PLAIN, 20));
            
            JLabel quantityLbl = new JLabel("Quantity: " + Integer.toString(vendingMachine.getItems().get(itemName).size()-1));
            quantityLbl.setFont(new Font("Arial", Font.PLAIN, 20));

            
            JLabel caloriesLbl = new JLabel("Calories: " + Float.toString(vendingMachine.getItems().get(itemName).get(0).getCalories()));
            caloriesLbl.setFont(new Font("Arial", Font.PLAIN, 20));

            
            JLabel priceLbl = new JLabel("Price: P" + Float.toString( vendingMachine.getItems().get(itemName).get(0).getPrice()));
            priceLbl.setFont(new Font("Arial", Font.PLAIN, 20));
            
            JButton btn = new JButton();
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (vendingMachine.selectItem(vendingMachine.getItems().get(itemName).get(0)) == false){
                        JOptionPane.showMessageDialog(null, "Out of stock.");
                        return;
                    }
                    
                    if (vendingMachine.getItems().get(itemName).get(0).getStandAlone() == false){
                        JOptionPane.showMessageDialog(null, "This item can't be sold alone.");
                        return;
                    }

                    int[] result = vendingMachine.produceChange();
                    switch (result[0]){
                        case -1:
                            JOptionPane.showMessageDialog(null, "Insufficient Payment, returning payment.");
                            JOptionPane.showMessageDialog(null, vendingMachine.returnPayment(), "Return", JOptionPane.PLAIN_MESSAGE);
                            break;
                        case -2:
                            JOptionPane.showMessageDialog(null, "Not enough change in vending machine.");
                            JOptionPane.showMessageDialog(null, vendingMachine.returnPayment(), "Return", JOptionPane.PLAIN_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Success! Here's your change.");
                            JOptionPane.showMessageDialog(null, arrToDenoms(result), "Change", JOptionPane.PLAIN_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Enjoy your " + vendingMachine.dispenseItem() + "!");
                    }
                    dispose();
                    sourceFrame.setVisible(true);
                }
                
            });
            btn.setText("Buy");

            
            subPanel.add(btn);
            subPanel.add(nameLbl);
            subPanel.add(quantityLbl);
            subPanel.add(caloriesLbl);
            subPanel.add(priceLbl);
            mainPanel.add(subPanel);
        }
    }

    /**
     * Converts an integer array representing quantity of denominations to 
     * a string array with human-readable format.
     *
     * @param arr the integer array representing quantity for each denomination
     * @return a string array with formatted denomination information
     */
    private String[] arrToDenoms(int[] arr){
        String[] denoms = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            denoms[i] = "[" + arr[i] + "x] P" + VendingMachine.denominations[i];
        }
        return denoms;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        promptLbl = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Items");

        promptLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        promptLbl.setText("List of Available Items");

        mainPanel.setLayout(new java.awt.GridLayout(5, 2, 0, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(promptLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(promptLbl)
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel promptLbl;
    // End of variables declaration//GEN-END:variables
}
