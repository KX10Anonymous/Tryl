
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
     * Receives the request parameter from the servlet class which delegates the database operations
     * @param request  HttpServletRequest 
     * @return  boolean
     */
    public boolean createUser(HttpServletRequest request){
         try {
            //Create a message digest with SHA key
            MessageDigest md = MessageDigest.getInstance("SHA");
            //Get the password from the post
            String password = request.getParameter("password");
            if (password.length() > 0) {
                md.update(password.getBytes());
                byte[] hashedBytes = md.digest();
                StringBuilder builder = new StringBuilder();
                
                String hashedPassword ="";
                //Convert the bytes to String
                for (byte bit : hashedBytes) {
                    //Append using #02x(HEX)
                    builder.append(String.format("#02x", bit));
                    //Convert the hashed hexas to String
                     hashedPassword = builder.toString();
                }
                
                  try {
                        
                        String name = request.getParameter("name");
                        String surname = request.getParameter("surname");
                        String email = request.getParameter("email");
                        String phone = request.getParameter("phone");
                        
                         statement = getConnection().createStatement();
                        Random rand = new Random();

                        // nextInt as provided by Random is exclusive of the top value so you need to add 1
                        int randomNum = rand.nextInt((1 - 293829366) + 1) + 1;

                        String query = "Insert into Users VALUES ("+ randomNum+", '"+name+"','"+ surname +"','"+ email +"','"+ phone + "','"+hashedPassword+"');";

                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
         return true;
    }
    
    
    
    /**
     * Creates 
     * Receives the request parameter from the servlet class which delegates the database operations
     * @param request  HttpServletRequest
     * @return boolean
     * Returns value to ensure that content has been saved
     */
    public boolean createAppointment(HttpServletRequest request){
        
        Date date = new Date(request.getParameter("date"));
        /**If the client is the one creating the appointment then the system should initialise to 
         * EStatus.CLIENT_CONFIRMED
         * If the Stylist is Creating, then the system should initialise to EStatus.STYLIST_CONFIRMED
         */
        
        //Get the Client Id
        String clientId = request.getSession().getAttribute("client_id").toString();
        //get The Stylist Id from the session Attributes
        String stylistId = request.getSession().getAttribute("stylist_id").toString();
        
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
       
        
        return true;
    }
    
    /**
     * Creates a hash function for the password string plaintext
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
