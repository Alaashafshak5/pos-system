/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.taxes;

/**
 *
 * @author Alaa Shafshak
 */

//payment adapter to use in every diff country tax
public interface TaxAdapter {    
    public float TaxPercentage();

}
