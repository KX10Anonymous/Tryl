/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            MessageDigest md = MessageDigest.getInstance("SHA");
            
            
            if(password.length() > 0){
                //Convert String to Bytes
                md.update(password.getBytes());
                byte[] hashedBytes = md.digest();
                
                StringBuilder builder = new StringBuilder();
                
                String hashedPassword;
                //Convert the bytes to String
                for (byte bit : hashedBytes) {
                    //Append using #02x(HEX)
                    builder.append(String.format("#02x", bit));
                    //Convert the hashed hexas to String
                     hashedPassword = builder.toString();
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
