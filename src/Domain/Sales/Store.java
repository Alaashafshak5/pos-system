/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import TechnicalServices.Persistence.Register;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alaa Shafshak
 */

//class Store with getters and setters
public class Store {
    private String location;
    private String name;
    private Register register;
    ProductCatalog productCatalog = new ProductCatalog();
    private List<Sale> SalesList = new ArrayList<>();

    private Store() {
        register = Register.getRegister();
        register.setProductCatalog(productCatalog);
    }
    
    
    public Register getRegister() {
        return register;
    }
    
    public Store(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" + "location=" + location + ", name=" + name + '}';
    }
   
    
    // we use the singleton pattern here to ensure that the store is created one time 
    private static Store firstInstance = null;

    public static Store getStore() {

        if (firstInstance == null) {

            firstInstance = new Store();
        }
        return firstInstance;
    }
}
