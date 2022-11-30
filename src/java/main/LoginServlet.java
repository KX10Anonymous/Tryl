/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J-ANONIMO
 */
public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //Instantiate the database utility class, this will also create the objects fro connection and statement
            DatabaseUtility utility = new DatabaseUtility();

            //Call the utility method to hash the password
            String passwordHash = utility.passwordHash(password);

            //Set query to retrieve the password based on user password and username
            String query = "SELECT * where username='" + username + "' AND passwordHash='" + passwordHash + "'";

            //Retrieve the Statement instance created from the DatabaseUtility constructor call
            Statement statement = utility.getStatement();
            
            //Execute query to retrieve the user from database using password and username combination
            ResultSet queryResult = statement.executeQuery(query);
            
            //Perform Actions if there's a matched record
            if(queryResult.next()){
                //Create User Session
                 HttpSession session = request.getSession();
                
                //Send user to the home page after successful login
                response.sendRedirect("home.html");
            }
            
            //Close the connection to the database;
            utility.closeConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
