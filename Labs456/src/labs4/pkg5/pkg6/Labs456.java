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

    public void login(javax.swing.JTextField username, javax.swing.JPasswordField password)throws Exception {
        System.out.println("JESTEM TU!");
        String name = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/lab-4-5-6_university_database?user=root&password=pwnage12";

        Connection c = DriverManager.getConnection(URL);
        Statement st = c.createStatement();
        String user = username.getText();
        String pass = password.getText();
        ResultSet rs = st.executeQuery("SELECT Name FROM students WHERE (Login LIKE '"+user+"' AND Password LIKE '"+pass+"')");
        //ResultSet rs = st.executeQuery("SELECT * FROM students");
       

        while (rs.next()){
            name = rs.getString("Name");
        }
        System.out.println(name);
        /**
         * @param args the command line arguments
         */

    }
}
