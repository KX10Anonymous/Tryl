/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author J-ANONIMO
 */
@Entity
@Table(name = "activity", catalog = "tryldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findById", query = "SELECT a FROM Activity a WHERE a.id = :id"),
    @NamedQuery(name = "Activity.findByCreated", query = "SELECT a FROM Activity a WHERE a.created = :created"),
    @NamedQuery(name = "Activity.findByText", query = "SELECT a FROM Activity a WHERE a.text = :text"),
    @NamedQuery(name = "Activity.findByActivityType", query = "SELECT a FROM Activity a WHERE a.activityType = :activityType"),
    @NamedQuery(name = "Activity.findByImageurl", query = "SELECT a FROM Activity a WHERE a.imageurl = :imageurl"),
    @NamedQuery(name = "Activity.findByActivitycol", query = "SELECT a FROM Activity a WHERE a.activitycol = :activitycol")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Column(name = "text", length = 100)
    private String text;
    
    @Basic(optional = false)
    @Column(name = "activity_type", nullable = false)
    private int activityType;
    
    @Column(name = "imageurl", length = 250)
    private String imageurl;
    
    @JoinColumns({
        @JoinColumn(name = "appointment_id", referencedColumnName = "stylist_id"),
        @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)})
    @ManyToOne(optional = false)
    private Appointments appointments;

    public Activity() {
    }

    public Activity(Integer id) {
        this.id = id;
    }

    public Activity(Integer id, Date created, int activityType) {
        this.id = id;
        this.created = created;
        this.activityType = activityType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public String getImageUrl() {
        return imageurl;
    }

    /**
     * 
     * @param imageurl 
     */
    public void setImageUrl(String imageurl) {
        this.imageurl = imageurl;
    }

    
    /**
     * 
     * @return 
     */
    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares Activity entity object for equality.
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        Activity other = (Activity) object;
        
        //Compare IDs
        if(!Objects.equals(other.id, this.id))
            return false;
        
        //Check if entity is instance of activity
        if (!(object instanceof Activity)) {
            return false;
        }
        
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "main.entities.Activity[ id=" + id + " ]";
    }
    
}
