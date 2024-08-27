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
public class CreditPayment implements PaymentADAPTER {

  //to handle the Credit Payment option
    private final float amount;
  

    public CreditPayment(float amount) {

        this.amount = amount;
    }
    
    @Override
    public String proceed() {
       
        return "You have chosen Credit Method!";
    }

    @Override
    public float getAmount() {
        return amount;
    }
    
}
