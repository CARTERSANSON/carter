/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystorecarterr1;

/**
 *
 * @author csanson2027
 */
import java.util.*;
public class MyStoreCarterR1 {
    public static void main(String[] args) {
        //constant for maximum budget
        final double MAX_BUDGET = 250.00;
        //calculate total spent
        double totalSpent = 0.0;
        //total amount of number items purchased
        int itemCount = 0;
        //set scanner
        Scanner scan = new Scanner(System.in);

        // set the items
        Item[]items = {
            new Item("T Shirt", 29.99),
            new Item("Shoes", 125.99),
            new Item("Jeans", 60.99),
            new Item("Jacket", 250.00),
            new Item("Hat", 25.99), 
            new Item("Shorts", 75.99),
            new Item("Blouse", 88.99)
        };
        
        
    System.out.println("Welcome to MyStore! Your maximum budget is $" + MAX_BUDGET);
    System.out.println("Here are the available items: ");
    //print items
    for (Item item: items){
        System.out.println(item);
    }
    while (true){
    System.out.println("Enter the item name to purchase ( or type 'quit' to exit): ");
    String input = scan.nextLine();
    // cgeck if user wants to quit
    if (input.equalsIgnoreCase("quit")){
        break; // exit loop
    }
    // look for item in the list 
    Item selectedItem = null;
    for (Item item : items){
        if(item.getName().equalsIgnoreCase(input)){
            selectedItem = item;
            break;
        }
    }
    // item is not found, inform user
    if (selectedItem == null){
        System.out.println("Sorry, we dont have that item. Please try again.");
        continue;
    }
    // checking if item would receive the budget
    if (totalSpent + selectedItem.getPrice() > MAX_BUDGET){
        System.out.println("Adding this item would exceed your budget. Current total: $" + totalSpent);
    } else {
        totalSpent += selectedItem.getPrice();
        itemCount++;
        // finishing shopping session
        System.out.println("You added: " + selectedItem);
        System.out.println(" Total Items: " + itemCount + ", Total Spent: $" + totalSpent);
        
    }
    }
    //end of shopping session
    System.out.println("Thank you for shopping at MyStore!");
    System.out.println("You bought " + itemCount + " items and Spent $" + totalSpent);
    scan.close();
        
}
}
    

class Item{
    private String strName;
    private double dblPrice; 
    
    public Item(String name, double price){
        this.strName = name;
        this.dblPrice = price;
    }
    
    public String getName(){
        return strName;
    }
    
    public void setName(String name){
        this.strName = name;
    }
    
    public double getPrice(){
        return dblPrice; 
    }
    
    public void setPrice(double price){
        this.dblPrice= price;
    }
    
    public String toString(){
        return "Item: " + strName + ", Price: $" + dblPrice; 
    }
}