/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

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
     * Receives the request parameter from the servlet class which delegates the database operations
     * @param request  HttpServletRequest 
     */
    public void createUser(HttpServletRequest request){
         try {
            //Create a message digest with MD5 key
            MessageDigest md = MessageDigest.getInstance("SHA");
            //Get the password from the post
            String password = request.getParameter("password");
            if (password.length() > 0) {
                md.update(password.getBytes());
                byte[] hashedBytes = md.digest();
                StringBuilder builder = new StringBuilder();

                //Convert the bytes to String
                for (byte bit : hashedBytes) {
                    //Append using #02x(HEX)
                    builder.append(String.format("#02x", bit));
                    //Convert the hashed hexas to String
                    String hashedPassword = builder.toString();
                    try {
                        
                        String name = request.getParameter("name");
                        String surname = request.getParameter("surname");
                        String email = request.getParameter("email");
                        String phone = request.getParameter("phone");
                        
                         statement = connection.createStatement();
                        Random rand = new Random();

                        // nextInt as provided by Random is exclusive of the top value so you need to add 1
                        int randomNum = rand.nextInt((1 - 293829366) + 1) + 1;

                        String query = "Insert into Users VALUES ("+ randomNum+", '"+name+"','"+ surname +"','"+ email +"','"+ phone + "','"+hashedPassword+"');";

                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
