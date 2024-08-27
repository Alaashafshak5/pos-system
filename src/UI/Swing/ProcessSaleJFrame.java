/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Swing;
import Domain.Sales.Store;
import TechnicalServices.Persistence.Register;
import UI.Swing.MainFrame;

import java.sql.SQLException;

/**
 *
 * @author Alaa Shafshak
 */
public class ProcessSaleJFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Store store = Store.getStore();
        store.setName("Lebanon");
        Register register = store.getRegister();
        MainFrame frame = new MainFrame(register);
        frame.setVisible(true);
    }
    
}
