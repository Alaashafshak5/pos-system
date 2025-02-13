/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;


/**
 *
 * @author Alaa Shafshak
 */

//Class Payment with getters and setters
public class Payment {
    private float amount;
    private int idPayment;
   
    public Payment(float amount) {
        this.amount = amount;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + '}';
    }
    
}
