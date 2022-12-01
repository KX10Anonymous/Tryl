/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.util.ArrayList;
import main.core.Appointment;
import java.util.HashMap;
import main.core.EAppointmentStatus;
import sun.util.calendar.LocalGregorianCalendar.Date;
/**
 *
 * @author J-ANONIMO
 */
public class AppointmentsManager {
    
    private final transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final transient VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);
    public static final String PROP_APPOINTMENTSAL = "appointmentsAL";
    public static final String PROP_APPOINTMENSHASHMAP = "appointmensHashMap";
    
    protected ArrayList<Appointment> appointmentsAL;
    protected HashMap<Integer,Appointment> appointmensHashMap;
    protected HashMap<EAppointmentStatus, Appointment> appointmentStatus;
    protected HashMap<Date, Appointment> appointmentsDates;
    
    /**
     * @return the appointmentsAL
     */
    public ArrayList<Appointment> getAppointmentsAL() {
        return appointmentsAL;
    }

    /**
     * @param appointmentsAL the appointmentsAL to set
     * @throws java.beans.PropertyVetoException
     */
    public void setAppointmentsAL(ArrayList<Appointment> appointmentsAL) throws PropertyVetoException {
        java.util.ArrayList<main.core.Appointment> oldAppointmentsAL = this.appointmentsAL;
        vetoableChangeSupport.fireVetoableChange(PROP_APPOINTMENTSAL, oldAppointmentsAL, appointmentsAL);
        this.appointmentsAL = appointmentsAL;
        propertyChangeSupport.firePropertyChange(PROP_APPOINTMENTSAL, oldAppointmentsAL, appointmentsAL);
    }

    /**
     * @return the appointmensHashMap
     */
    public HashMap<Integer,Appointment> getAppointmensHashMap() {
        return appointmensHashMap;
    }

    /**
     * @param appointmensHashMap the appointmensHashMap to set
     * @throws java.beans.PropertyVetoException
     */
    public void setAppointmensHashMap(HashMap<Integer,Appointment> appointmensHashMap) throws PropertyVetoException {
        java.util.HashMap<java.lang.Integer, main.core.Appointment> oldAppointmensHashMap = this.appointmensHashMap;
        vetoableChangeSupport.fireVetoableChange(PROP_APPOINTMENSHASHMAP, oldAppointmensHashMap, appointmensHashMap);
        this.appointmensHashMap = appointmensHashMap;
        propertyChangeSupport.firePropertyChange(PROP_APPOINTMENSHASHMAP, oldAppointmensHashMap, appointmensHashMap);
    }
    
    /**
     * Add appointment to the Status hash map, will help pulling appointments based on status
     * @param status
     * @param appointment
     * @return 
     */
    public boolean addAppointmenByStatus(EAppointmentStatus status, Appointment appointment){
        return true;
    }
    
}
