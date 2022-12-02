/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.utility;

/**
 *
 * @author J-ANONIMO
 */
public class UserUtility {
    /**
     * Validates email address, still to add regular expression
     * @param email
     * @return 
     */
    public static boolean isEmailValid(String email){
        return !email.isEmpty() && email.contains("@");
    }
    
    /**
     * Validates phone, still to add regular expression
     * @param phone
     * @return 
     */
    public static boolean isPhoneValid(String phone){
        return !phone.isBlank() && !phone.isEmpty();
    }
}
