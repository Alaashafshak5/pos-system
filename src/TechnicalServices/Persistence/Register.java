/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.ProductCatalog;
import Domain.Sales.Sale;
//import com.sun.jndi.ldap.PersistentSearchControl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alaa Shafshak
 */
public class Register {
   
    private ProductCatalog productCatalog;
    private Sale sale;

    public void endSale(int idSale) throws SQLException {
        PersistentStorage.instance.endSale(idSale);
    }

    public void enterLineltem(int idItem,int idSale, int quantity) throws SQLException {
        
        double price = quantity*productCatalog.descriptions.get(idItem).getPrice();
        PersistentStorage.instance.enterLineItem(quantity, idSale, idItem, (float) price);

    }

    public void makeNewSale() throws SQLException {

         PersistentStorage.instance.makeNewSale();

    }

    public void makePayment(float amount , int idSale) throws SQLException {

        PersistentStorage.instance.makePayment(amount, idSale);

    }
    
    public ResultSet getItem(int idItem){
        return TransferFromDB.instance.getItem(idItem);
    }
    
    public ResultSet getCatalog(){
        return TransferFromDB.instance.getCatalog();
    }

    public float getTotal() {
        if (sale == null) {
            return 0;
        }
        return sale.getTotal();
    }
  
      // we use the singleton pattern here to ensure that the store is created one time 
    private static Register firstInstance = null;

    public static Register getRegister() {

        if (firstInstance == null) {

            firstInstance = new Register();
        }
        return firstInstance;
    }

    
    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
}
