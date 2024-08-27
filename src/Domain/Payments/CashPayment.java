/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;

/**
 *
 * @author karene
 */
public class CashPayment implements PaymentADAPTER{
 //to handle the Cash Payment option
    private final float amount;
 

    public CashPayment(float amount) {
        this.amount = amount;
       
    }
    
    @Override
    public String proceed() {
       
        return "You have chosen Cash Method!";
       
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
