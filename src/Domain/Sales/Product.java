/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

/**
 *
 * @author Alaa Shafshak
 */

//class Product with getters and setters
public class Product {
    private int idproduct;
    private float price;
    private String description;
    private int quantity;

    public Product(int idproduct, float price, String description, int quantity) {
        this.idproduct = idproduct;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(float price, String description) {
        this.price = price;
        this.description = description;
    }
    
    public String getItemName() {
        return description;
    }

    public void setItemName(String itemName) {
        this.description = itemName;
    }

    public int getIdItem() {
        return idproduct;
    }

    public void setIdItem(int idproduct) {
        this.idproduct = idproduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public String toString() {
        return "Item{" + "idItem=" + idproduct + ", price=" + price + ", itemName=" + description + "quantity=" + quantity +'}';
    }
    
}
