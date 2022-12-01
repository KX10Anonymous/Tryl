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

    private ArrayList<Appointment> appointmentsAL;
    protected HashMap<Integer, Appointment> appointmentsHashMap;
    protected HashMap<EAppointmentStatus, Appointment> appointmentStatusHashMap;
    protected HashMap<Date, Appointment> appointmentsDateHashMap;
    protected EListRequest request;

    /**
     *
     * @param request
     */
    public AppointmentsManager(EListRequest request) {

        if (null == request) {
            //Choose Array List in case request is null
            appointmentsAL = new ArrayList<>();
        } else { //Create array list if request is made for appointments arraylist
            switch (request) {
                case ARRAY_LIST:
                    appointmentsAL = new ArrayList<>();
                    break;
                case DATE:
                    //Create hash map for appointments date.
                    appointmentsDateHashMap = new HashMap<>();
                    break;
                case HASH_MAP:
                    //Create Hash Map for appointment, user uses this to pull all appointments
                    appointmentsHashMap = new HashMap<>();
                    break;
                default:
                    appointmentStatusHashMap = new HashMap<>();
                    break;
            }
            this.request = request;
        }
    }

    /**
     * @return the appointmentsAL
     */
    public ArrayList<Appointment> getAppointmentsAL() {
        if (getRequest() == EListRequest.ARRAY_LIST) {
            return appointmentsAL;
        } else {
            return new ArrayList<>();
        }

    }

    /**
     * @param appointmentsAL the appointmentsAL to set.
     * @throws java.beans.PropertyVetoException
     */
    public void setAppointmentsAL(ArrayList<Appointment> appointmentsAL) throws PropertyVetoException {
        java.util.ArrayList<main.core.Appointment> oldAppointmentsAL = this.appointmentsAL;
        vetoableChangeSupport.fireVetoableChange(PROP_APPOINTMENTSAL, oldAppointmentsAL, appointmentsAL);
        this.appointmentsAL = appointmentsAL;
        propertyChangeSupport.firePropertyChange(PROP_APPOINTMENTSAL, oldAppointmentsAL, appointmentsAL);
    }

    /**
     * @return the appointmentsHashMap
     */
    public HashMap<Integer, Appointment> getAppointmensHashMap() {
        if (getRequest() == EListRequest.HASH_MAP) {
            return getAppointmentsHashMap();
        } else {
            return new HashMap<>();
        }
    }

    /**
     * @param appointmensHashMap the appointmentsHashMap to set.
     * @throws java.beans.PropertyVetoException
     */
    public void setAppointmensHashMap(HashMap<Integer, Appointment> appointmensHashMap) throws PropertyVetoException {
        java.util.HashMap<java.lang.Integer, main.core.Appointment> oldAppointmensHashMap = this.getAppointmentsHashMap();
        vetoableChangeSupport.fireVetoableChange(PROP_APPOINTMENSHASHMAP, oldAppointmensHashMap, appointmensHashMap);
        this.setAppointmentsHashMap(appointmensHashMap);
        propertyChangeSupport.firePropertyChange(PROP_APPOINTMENSHASHMAP, oldAppointmensHashMap, appointmensHashMap);
    }

    /**
     * Add appointment to the Status hash map, will help pulling appointments.
     * based on status
     *
     * @param status
     * @param appointment
     * @return
     */
    public boolean addAppointmenByStatus(EAppointmentStatus status, Appointment appointment) {
        if (appointment != null) {
            appointmentStatusHashMap.put(status, appointment);
        }
        return true;
    }

    /**
     * Utility method to check if the appointment is NULL or not.
     * @param appointment
     * @return 
     */
    private boolean isAppointmentNull(Appointment appointment){
        return appointment == null;
    }
    
    /**
     * Adds appointment to hash map by date.
     * @param date
     * @param appointment
     * @return 
     */
    public boolean addAppointmentsByDate(Date date, Appointment appointment){
        if(!isAppointmentNull(appointment)){
            appointmentsDateHashMap.put(date, appointment);
        }
        return true;
    }
    
    /**
     * Adds appointment to hash map using ID key.
     * @param id
     * @param appointment
     * @return 
     */
    public boolean addAppointmentToHashMap(int id, Appointment appointment){
        if(!isAppointmentNull(appointment)){
            appointmentsHashMap.put(id, appointment);
        }
        return true;
    }
    
    /**
     * @return the appointmentsHashMap
     */
    public HashMap<Integer, Appointment> getAppointmentsHashMap() {
        if(request == EListRequest.HASH_MAP){
            return appointmentsHashMap;
        }else{
            return new HashMap<>();
        }   
    }

    /**
     * @param appointmentsHashMap the appointmentsHashMap to set
     */
    public void setAppointmentsHashMap(HashMap<Integer, Appointment> appointmentsHashMap) {
        this.appointmentsHashMap = appointmentsHashMap;
    }

    /**
     * @return the appointmentStatusHashMap
     */
    public HashMap<EAppointmentStatus, Appointment> getAppointmentStatusHashMap() {
        if (request == EListRequest.STATUS) {
            return appointmentStatusHashMap;
        } else {
            return new HashMap<>();
        }
    }

    /**
     * @param appointmentStatusHashMap the appointmentStatusHashMap to set
     */
    public void setAppointmentStatusHashMap(HashMap<EAppointmentStatus, Appointment> appointmentStatusHashMap) {
        this.appointmentStatusHashMap = appointmentStatusHashMap;
    }

    /**
     * @return the appointmentsDateHashMap
     */
    public HashMap<Date, Appointment> getAppointmentsDateHashMap() {
        if (request == EListRequest.DATE) {
            return appointmentsDateHashMap;
        } else {
            return new HashMap<>();
        }

    }

    /**
     * @param appointmentsDateHashMap the appointmentsDateHashMap to set
     */
    public void setAppointmentsDateHashMap(HashMap<Date, Appointment> appointmentsDateHashMap) {
        this.appointmentsDateHashMap = appointmentsDateHashMap;
    }

    /**
     * @return the request
     */
    public EListRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(EListRequest request) {
        this.request = request;
    }

}
