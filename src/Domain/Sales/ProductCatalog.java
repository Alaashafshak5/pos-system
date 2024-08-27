/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Sales.Product;
import TechnicalServices.Persistence.DataSource;
import TechnicalServices.Persistence.TransferFromDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alaa Shafshak
 */


public class ProductCatalog {

    public Map<Integer, Product> descriptions = new HashMap<Integer, Product>();

    public ProductCatalog() {
        loadSpecs();
    }
//loading the data from db
    public void loadSpecs() {
        ResultSet set = TransferFromDB.instance.getCatalog();
        int idproduct;
        float price;
        String description;
        int quantity;
        try {
            while (set.next()) {
                idproduct = Integer.parseInt(set.getString(1));
                price = Float.parseFloat(set.getString(2));
                description = set.getString(3);
                quantity = set.getInt(4);
                descriptions.put(idproduct,new Product(idproduct,price,description, quantity));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public Product getItem(int id) {
        return descriptions.get(id);
    }
}
