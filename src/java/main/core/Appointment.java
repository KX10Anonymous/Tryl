/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author J-ANONIMO
 */
public class Appointment {
    protected Date date;
    protected String longitude;
    protected String latitude;
    protected EAppointmentStatus appointmentStatus;
    protected ERating rating;
    protected int id;
    /**
     * 
     * @param date
     * @param longitude
     * @param latitude
     * @param status
     * @param rating 
     */
    public Appointment(Date date, String longitude, String latitude, EAppointmentStatus status, ERating rating){
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.appointmentStatus = status;
        this.rating = rating;
    }
    
    /**
     * Constructor responsible for creating the object from the database record using ID
     * @param id
     * @param date
     * @param longitude
     * @param latitude
     * @param status
     * @param rating 
     */
    public Appointment(int id, Date date, String longitude, String latitude, EAppointmentStatus status, ERating rating){
        this.id = id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.appointmentStatus = status;
        this.rating = rating;
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
     * @return the rating
     */
    public ERating getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(ERating rating) {
        this.rating = rating;
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
        return appointmentStatus == EAppointmentStatus.OPEN;
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
}
