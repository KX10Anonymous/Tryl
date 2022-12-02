/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author J-ANONIMO
 */
@Embeddable
public class AppointmentsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "client_id", nullable = false)
    private int clientId;
    
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private int id;
    
    @Basic(optional = false)
    @Column(name = "stylist_id", nullable = false)
    private int stylistId;

    public AppointmentsPK() {
    }

    /**
     * 
     * @param clientId
     * @param id
     * @param stylistId 
     */
    public AppointmentsPK(int clientId, int id, int stylistId) {
        this.clientId = clientId;
        this.id = id;
        this.stylistId = stylistId;
    }

    /**
     * 
     * @return 
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * 
     * @param clientId 
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public int getStylistId() {
        return stylistId;
    }

    /**
     * 
     * @param stylistId 
     */
    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientId;
        hash += (int) id;
        hash += (int) stylistId;
        return hash;
    }

    /**
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentsPK)) {
            return false;
        }
        AppointmentsPK other = (AppointmentsPK) object;
        if (this.clientId != other.clientId) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return this.stylistId == other.stylistId;
    }

    @Override
    public String toString() {
        return "main.entities.AppointmentsPK[ clientId=" + clientId + ", id=" + id + ", stylistId=" + stylistId + " ]";
    }
    
}
