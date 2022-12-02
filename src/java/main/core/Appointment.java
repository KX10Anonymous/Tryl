/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core;
import java.util.ArrayList;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author J-ANONIMO
 */
public class Appointment {
    private Date date;
    private String longitude;
    private String latitude;
    private EAppointmentStatus appointmentStatus;
    private int id;
    private ArrayList<Style> styles;
    
    /**
     * 
     * @param date
     * @param longitude
     * @param latitude
     * @param status 
     */
    public Appointment(Date date, String longitude, String latitude, EAppointmentStatus status){
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.appointmentStatus = status;
        styles = new ArrayList<>();
    }
    
    /**
     * Constructor responsible for creating the object from the database record using ID
     * @param id
     * @param date
     * @param longitude
     * @param latitude
     * @param status 
     */
    public Appointment(int id, Date date, String longitude, String latitude, EAppointmentStatus status){
        this.id = id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.appointmentStatus = status;
        styles = new ArrayList<>();
    }

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
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the appointmentStatus
     */
    public EAppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    /**
     * @param appointmentStatus the appointmentStatus to set
     */
    public void setAppointmentStatus(EAppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Checks if the appointment has been fulfilled and returns true if appointment has been closed
     * @return true/false
     */
    public boolean isAppointmentFulfilled(){
        return appointmentStatus == EAppointmentStatus.CLOSED;   
    }
    
    
    /**
     * Checks if the appointment has been fulfilled and returns true if appointment has been opened
     * @return true/false
     */
    public boolean isAppointmentAlive(){
        return appointmentStatus == EAppointmentStatus.UNCONFIRMED;
    }
    
    /**
     * Confirms the appointment
     * @return 
     */
    public boolean confirmAppointment(){
        if(appointmentStatus != EAppointmentStatus.VERIFIED){
            //Set Status to verified if appointment is not
            appointmentStatus = EAppointmentStatus.VERIFIED;
        }
        return true;
    }
    
    /**
     * Closes the appointment once it's time has expired.
     * @return true
     */
    public boolean closeAppointment(){
        if(appointmentStatus != EAppointmentStatus.CLOSED){
            //Close the appointment
            appointmentStatus = EAppointmentStatus.CLOSED;
        }
        return true;
    }
    
    /**
     * Uses date to close appointment when it is over time, checks by day.
     * @param date
     * @return 
     */
    public boolean closeAppointment(Date date){
        if(date.getMonth() == this.date.getMonth()){
            //Check if the current day is greater than the appointment date
            if(date.getDayOfMonth() > this.date.getDayOfMonth()){
                appointmentStatus = EAppointmentStatus.CLOSED;
            } 
        }
        return true;
    }

    /**
     * @return the styles
     */
    public ArrayList<Style> getStyles() {
        return styles;
    }

    /**
     * @param styles the styles to set
     */
    public void setStyles(ArrayList<Style> styles) {
        this.styles = styles;
    }
    
    /**
     * Adds style to container and returns true if operation was a success.
     * @param style
     * @return 
     */
    public boolean addStyles(Style style){
        if(style != null){
            if(styles != null){
                styles.add(style);
            }else{
                //In case the container is null
                styles = new ArrayList<>();
                //Add style to container
                styles.add(style);
            }
            return true;
            
        }
        return false;
    }
}
