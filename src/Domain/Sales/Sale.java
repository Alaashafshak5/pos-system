/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Payments.Payment;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alaa Shafshak
 */
//class Sale with getters and setters
public class Sale {

    private boolean isComplete;
    private Payment payment;
    private Date date;
    private List<SalesLineItem> ls = new ArrayList<>();

    public Sale(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public void makeLineItem(Product product, int quantity) {
        ls.add(new SalesLineItem(quantity, product));
    }

    public void makePayment(float amount) {
        this.payment = new Payment(amount);
    }

     public float getTotal() {
        float total = 0;
        try{
        Iterator<SalesLineItem> i = ls.iterator();

        while (i.hasNext()) {
            SalesLineItem sli =   (SalesLineItem) i.next();
            total += sli.getPacketPrice();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Sale{" + "isComplete=" + isComplete + '}';
    }

}
