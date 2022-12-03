/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author J-ANONIMO
 */
public class RegisterServlet extends HttpServlet {

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
          
            DatabaseUtility utility = new DatabaseUtility();
            //Get the password from the post
            String password = request.getParameter("password");
            
            //Hash the password
            String passwordHash = utility.passwordHash(password);
            
            //Retrieve the remining values needed for user registration
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            //Retrieve the statement from the connection in the database utility class
            Statement statement = utility.getStatement();
            Random rand = new Random();
            // nextInt as provided by Random is exclusive of the top value so you need to add 1
            int randomNum = rand.nextInt((1 - 2938293) + 1) + 1;
            String query = "Insert into Users VALUES (" + randomNum + ", '" + name + "','" + surname + "','" + email + "','" + phone + "','" + passwordHash + "');";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
