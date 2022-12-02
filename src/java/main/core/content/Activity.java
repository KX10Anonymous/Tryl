/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content;

import main.user.Client;
import main.user.Therapist;
import sun.util.calendar.LocalGregorianCalendar.Date;




/**
 *
 * @author J-ANONIMO
 */
public class Activity {
    protected Date date;
    protected EActivityType type;
    protected Client cient;
    protected Therapist stylist;
    
    /**
     * 
     * @param date
     * @param type 
     */
    public Activity(Date date, EActivityType type){
        this.date = date;
        this.type = type;
    }
    
    /**
     * 
     * @param date
     * @param type
     * @param client
     * @param stylist 
     */
    public Activity(Date date, EActivityType type, Client client, Therapist stylist){
        this.date = date;
        this.cient = client;
        this.stylist = stylist;
        this.type = type;
    }
   
}
