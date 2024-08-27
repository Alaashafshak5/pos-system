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
//class SalesLineItem with getters and setters
public class SalesLineItem {
    private int quantity;
    private float packetPrice = 0;
    private int idItem;
    private int idSale;
    private Product product;

    public SalesLineItem(int quantity) {
        this.quantity = quantity;
    }

    public SalesLineItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }


    public Product getItem() {
        return product;
    }

    public void setItem(Product item) {
        this.product = item;
    }

    public float getPacketPrice() {
         return packetPrice*quantity;
    }

    public void setPacketPrice(float packetPrice) {
        this.packetPrice = packetPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "SalesLineItem{" + "quantity=" + quantity + ", packetPrice=" + packetPrice + '}';
    }


    
}
