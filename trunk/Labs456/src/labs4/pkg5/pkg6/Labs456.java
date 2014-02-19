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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author moaiddip
 */
public class Labs456 {
    private boolean loggedIn = false;
    private String userName = null;
    
    public ArrayList list;
    Gui gui = new Gui();
    int id;
    
    String URL = "jdbc:mysql://127.0.0.1:3306/lab-4-5-6_university_database?user=new&password=new";
    Connection c;
    Statement st;



    public void login(javax.swing.JTextField username, javax.swing.JPasswordField password) {
        
        try{
        
        String name = null;
       

        this.st = c.createStatement();
        this.c = DriverManager.getConnection(URL);
        String user = username.getText();
        String pass = password.getText();
        ResultSet rs = st.executeQuery("SELECT studName FROM student WHERE (studLogin LIKE '"+user+"' AND studPass LIKE '"+pass+"')");
        //ResultSet rs = st.executeQuery("SELECT * FROM students");
       

        while(rs.next()){  
            name = rs.getString("studName");
        }
        if (!name.equals(null)){
            loggedIn=true;
            userName = name;
            ResultSet res = st.executeQuery("SELECT idstudent FROM student WHERE (studLogin LIKE '"+user+"' AND studPass LIKE '"+pass+"')");
            while(res.next()){
                id= res.getInt("idstudent");
            }
            
        }
        
        }
        catch(SQLException ex){
            
        }

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
    public void getCourses(int id) throws SQLException{
        
        list = new ArrayList();
        id=this.id;
        this.st = c.createStatement();
        this.c = DriverManager.getConnection(URL);
        ResultSet cs = st.executeQuery("SELECT courseName FROM course JOIN studc ON (studc.CourseId=course.idcourse) WHERE (studc.studId="+id+")");
        while(cs.next()){
            list.add(cs.getString("courseName"));
        }
        
        
    }
}
