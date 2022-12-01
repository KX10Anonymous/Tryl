/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content;

import main.user.Client;
import main.user.Stylist;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author J-ANONIMO
 */
public class ImagePost extends Activity {
   protected ImageResource resource;
  
   
    /**
     * 
     * @param resource
     * @param date
     * @param type 
     */
    public ImagePost(ImageResource resource, Date date, EActivityType type) {
        super(date, type);
        this.resource = resource;
    }
    
    /**
     * 
     * @param resource
     * @param date
     * @param type
     * @param client
     * @param stylist 
     */
    public ImagePost(ImageResource resource, Date date, EActivityType type, Client client, Stylist stylist){
        super(date, type, client, stylist);
        this.resource = resource;
    }

    /**
     * @return the resource
     */
    public ImageResource getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(ImageResource resource) {
        this.resource = resource;
    }

}
