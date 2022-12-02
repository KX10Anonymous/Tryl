/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author J-ANONIMO
 */
@Entity
@Table(name = "appointments", catalog = "tryldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointments.findAll", query = "SELECT a FROM Appointments a"),
    @NamedQuery(name = "Appointments.findByClientId", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.clientId = :clientId"),
    @NamedQuery(name = "Appointments.findById", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.id = :id"),
    @NamedQuery(name = "Appointments.findByStylistId", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.stylistId = :stylistId"),
    @NamedQuery(name = "Appointments.findByLongitude", query = "SELECT a FROM Appointments a WHERE a.longitude = :longitude"),
    @NamedQuery(name = "Appointments.findByLatitude", query = "SELECT a FROM Appointments a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "Appointments.findByAppointmentStatus", query = "SELECT a FROM Appointments a WHERE a.appointmentStatus = :appointmentStatus"),
    @NamedQuery(name = "Appointments.findByAppointmentDate", query = "SELECT a FROM Appointments a WHERE a.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "Appointments.findByCreated", query = "SELECT a FROM Appointments a WHERE a.created = :created")})
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentsPK appointmentsPK;
    
    @Basic(optional = false)
    @Column(name = "longitude", nullable = false, length = 100)
    private String longitude;
    
    @Basic(optional = false)
    @Column(name = "latitude", nullable = false, length = 100)
    private String latitude;
    
    @Basic(optional = false)
    @Column(name = "appointmentStatus", nullable = false)
    private int appointmentStatus;
    
    @Basic(optional = false)
    @Column(name = "appointmentDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;
    
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    
    @JoinColumn(name = "stylist_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
    private Collection<Activity> activityCollection;

    public Appointments() {
    }

    /**
     * 
     * @param appointmentsPK 
     */
    public Appointments(AppointmentsPK appointmentsPK) {
        this.appointmentsPK = appointmentsPK;
    }

    /**
     * 
     * @param appointmentsPK
     * @param longitude
     * @param latitude
     * @param appointmentStatus
     * @param appointmentDate 
     */
    public Appointments(AppointmentsPK appointmentsPK, String longitude, String latitude, int appointmentStatus, Date appointmentDate) {
        this.appointmentsPK = appointmentsPK;
        this.longitude = longitude;
        this.latitude = latitude;
        this.appointmentStatus = appointmentStatus;
        this.appointmentDate = appointmentDate;
    }

    /**
     * 
     * @param clientId
     * @param id
     * @param stylistId 
     */
    public Appointments(int clientId, int id, int stylistId) {
        this.appointmentsPK = new AppointmentsPK(clientId, id, stylistId);
    }

    /**
     * 
     * @return 
     */
    public AppointmentsPK getAppointmentsPK() {
        return appointmentsPK;
    }

    /**
     * 
     * @param appointmentsPK 
     */
    public void setAppointmentsPK(AppointmentsPK appointmentsPK) {
        this.appointmentsPK = appointmentsPK;
    }

    /**
     * 
     * @return 
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude 
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return 
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude 
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return 
     */
    public int getAppointmentStatus() {
        return appointmentStatus;
    }

    /**
     * 
     * @param appointmentStatus 
     */
    public void setAppointmentStatus(int appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    /**
     * 
     * @return 
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * 
     * @param appointmentDate 
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * 
     * @return 
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 
     * @param created 
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 
     * @return 
     */
    public Users getUsers() {
        return users;
    }

    /**
     * 
     * @param users 
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * 
     * @return 
     */
    public Users getUsers1() {
        return users1;
    }

    /**
     * 
     * @param users1 
     */
    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    /**
     * 
     * @return 
     */
    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    /**
     * 
     * @param activityCollection 
     */
    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentsPK != null ? appointmentsPK.hashCode() : 0);
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
        if (!(object instanceof Appointments)) {
            return false;
        }
        Appointments other = (Appointments) object;
        if ((this.appointmentsPK == null && other.appointmentsPK != null) || (this.appointmentsPK != null && !this.appointmentsPK.equals(other.appointmentsPK))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "main.entities.Appointments[ appointmentsPK=" + appointmentsPK + " ]";
    }
    
}
