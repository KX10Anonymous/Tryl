/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content;

import main.user.Client;
import main.user.Therapist;
import sun.util.calendar.LocalGregorianCalendar;

/**
 *
 * @author J-ANONIMO
 */
public class Comment extends Activity{
    private String text;

    /**
     * 
     * @param text
     * @param date
     * @param type 
     */
    public Comment(String text, LocalGregorianCalendar.Date date, EActivityType type) {
        super(date, type);
        
        //Validate the text before assigning
        if(validateText(text) == true){
            this.text = text;
        }
    }

    /**
     * 
     * @param date
     * @param type
     * @param client
     * @param stylist 
     */
    public Comment(String text,LocalGregorianCalendar.Date date, EActivityType type, Client client, Therapist stylist) {
        super(date, type, client, stylist);
        
         //Validate the text before assigning
        if(validateText(text) == true){
            this.text = text;
        }
    }
    
    /**
     * Ensure text is not blank and text has got less than 100 characters
     * @param text
     * @return 
     */
    private boolean validateText(String text){
        if(!text.isBlank()){
            if(text.length() <= 100){
                return true;
            }
        }
        return false;
    }
    
}
