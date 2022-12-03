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
public class Review {
    protected Date date;
    protected Client client;
    protected Therapist stylist;
    protected EReviewLevel level;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the stylist
     */
    public Therapist getStylist() {
        return stylist;
    }

    /**
     * @param stylist the stylist to set
     */
    public void setStylist(Therapist stylist) {
        this.stylist = stylist;
    }

    /**
     * @return the level
     */
    public EReviewLevel getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(EReviewLevel level) {
        this.level = level;
    }
    
    
}
