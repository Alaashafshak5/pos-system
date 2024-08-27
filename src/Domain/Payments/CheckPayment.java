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
public class CheckPayment implements PaymentADAPTER{
//to handle the Check Payment option
    private final float amount;

    public CheckPayment(float amount) {
        this.amount = amount;
      
    }

   // public CheckPayment() {
    //}
    
    @Override
    public String proceed() {
       
        return "you have chosen check method!";
    }

    @Override
    public float getAmount() {
        return amount;
    }
    
}
