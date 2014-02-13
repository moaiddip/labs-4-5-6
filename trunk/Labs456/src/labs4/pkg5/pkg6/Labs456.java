/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs4.pkg5.pkg6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moaiddip
 */
public class Labs456 {
    public void login(javax.swing.JTextField username, javax.swing.JPasswordField password){
        System.out.println("JESTEM TU!");
        try {
            String URL = "jdbc:mysql://127.0.0.1:3306/lab-4-5-6_university_database?user=test&password=test";
            
            Connection c = DriverManager.getConnection(URL);
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
       

    while(rs.next () 
        ){
                int nbr = rs.getInt("StudentId");
        String name = rs.getString("Name");
        System.out.println("Student Name: " + name + " \nand student number " + nbr + "\n\n");
    }

    c.close ();
     } catch (SQLException ex) {
            Logger.getLogger(Labs456.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    
}
