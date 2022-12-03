
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.beans.PropertyChangeSupport;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J-ANONIMO
 */
public class DatabaseUtility {

    private Connection connection;
    private Statement statement;

    public DatabaseUtility() throws SQLException, ClassNotFoundException {
        try {
            //Initialize the necessary object for DB operations
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Create the new connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
    }
     
    
    /**
     * Creates a hash function for the password string plain text
     * @param password
     * @return 
     */
    public String passwordHash(String password){
        String hashedPass = new String();
         try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            
            
            if(password.length() > 0){
                //Convert String to Bytes
                md.update(password.getBytes());
                byte[] hashedBytes = md.digest();
                
                StringBuilder builder = new StringBuilder();
                
                String tempHashString = new String();
                //Convert the bytes to String
                for (byte bit : hashedBytes) {
                    //Append using #02x(HEX)
                    builder.append(String.format("#02x", bit));
                    //Convert the hashed hexas to String
                     tempHashString = builder.toString();
                }
                
                hashedPass =  tempHashString;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         return hashedPass;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
    
    
    public void closeConnection() throws SQLException{
        connection.close();
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }
    
    
   
}
