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

  public class LebanonTax implements TaxAdapter{
    //lebanon tax class
    @Override
    public float TaxPercentage(){
        float taxLebanon= (float) 0.11;
        return taxLebanon ;
    }
    
 
}
