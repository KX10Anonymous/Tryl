/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.user;

import main.core.content.management.AppointmentsManager;

/**
 *
 * @author J-ANONIMO
 */
public class User {
    protected int id;
    protected String firstname;
    protected String surname;
    protected String email;
    protected String phone;
    protected AppointmentsManager appointmentsManager;
    
    public User(){
        id = 0;
        firstname = "";
        surname = "";
        email = "";
        phone = "";
    }
    
    public User(int id, String surname, String firstname, String phone, String email){
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the appointmentsManager
     */
    public AppointmentsManager getAppointmentsManager() {
        return appointmentsManager;
    }

    /**
     * @param appointmentsManager the appointmentsManager to set
     */
    public void setAppointmentsManager(AppointmentsManager appointmentsManager) {
        this.appointmentsManager = appointmentsManager;
    }
}
