/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.Product;
import Domain.Sales.ProductCatalog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alaa Shafshak
 */
public class TransferFromDB {
    
    private String findItemByKeyString = "select * from product where idproduct = ?";
    private String findItemByNameString = "select * from product where description = ?";
    private String findAllItemsString = "select * from product ";
    private String showCatalogString = "select product.price, product.description, product.quantity from product";
    private PreparedStatement findItemByKeyStmt;
    private PreparedStatement findItemByNameStmt;
    private PreparedStatement findAllItemsStmt;
    private PreparedStatement showCatalogStmt;
    private TransferFromDB(){
        try {
            findItemByKeyStmt = DataSource.getConnection().prepareStatement(findItemByKeyString);
            findItemByNameStmt = DataSource.getConnection().prepareStatement(findItemByNameString);
            findAllItemsStmt = DataSource.getConnection().prepareStatement(findAllItemsString);
            showCatalogStmt = DataSource.getConnection().prepareStatement(showCatalogString);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //function to get product by its id from db
    public ResultSet getItem(int idproduct){
        try {
            findItemByKeyStmt.setString(1,  String.valueOf(idproduct));
            ResultSet set = findItemByKeyStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //function t get product by itd name
    public Product getProductByName(String name) throws SQLException{
        findItemByNameStmt.setString(1, name);
        ResultSet set = findItemByNameStmt.executeQuery();
        if(set.next()){
           return new Product(set.getInt(1), set.getFloat(2), name, set.getInt(4)); 
        }
        return null;
        
    }
    // function that gets all the products in the store
    public ResultSet getCatalog(){
        try {
            ResultSet set = findAllItemsStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    // show catalog but return default table model
    public DefaultTableModel showCatalog() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        ResultSet set = showCatalogStmt.executeQuery();
        while (set.next()) {
            String name = set.getString(2);
            int quantity = set.getInt(3);
            float price = set.getFloat(1);
            model.addRow(new Object[]{name, quantity, price});
            
        }
        set.close();
        return model;
    }
    
    
    public static final TransferFromDB instance = new TransferFromDB();
}
