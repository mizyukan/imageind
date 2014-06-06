package проект;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class DataBase {
    
    private Connection c;
    
    DataBase() {  
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mysql", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void insertImageColor(String path, long r, long g, long b) {
        try {
            Statement st3 = c.createStatement();
            //System.out.println("INSERT INTO color_base (path, Red, Green, Blue) values ('"+path+"','"+r+"','"+g+"','"+b+"')");
            st3.executeUpdate("INSERT INTO color_base (path, Red, Green, Blue) values ('"+path+"','"+r+"','"+g+"','"+b+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

}
