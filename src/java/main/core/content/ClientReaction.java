/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content;

import main.user.Client;
import main.user.Stylist;
import sun.util.calendar.LocalGregorianCalendar;

/**
 *
 * @author J-ANONIMO
 */
public class ClientReaction extends Activity {
    
    protected EPostReaction reaction;
    
    
    /**
     * 
     * @param date
     * @param type
     * @param client
     * @param stylist 
     */
    public ClientReaction(LocalGregorianCalendar.Date date, EActivityType type, Client client, Stylist stylist) {
        super(date, type, client, stylist);
    }
    
    /**
     * 
     * @param date
     * @param type 
     */
    public ClientReaction(LocalGregorianCalendar.Date date, EActivityType type) {
        super(date, type);
    }

    
    /**
     * @return the reaction
     */
    public EPostReaction getReaction() {
        return reaction;
    }

    /**
     * @param reaction the reaction to set
     */
    public void setReaction(EPostReaction reaction) {
        this.reaction = reaction;
    }
    
    
    
}
