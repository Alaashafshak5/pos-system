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

//Payment adapter to use in different payment options
public interface PaymentADAPTER {
    public String proceed();
    public float getAmount();
}
