/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "reaction", catalog = "tryldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reaction.findAll", query = "SELECT r FROM Reaction r"),
    @NamedQuery(name = "Reaction.findById", query = "SELECT r FROM Reaction r WHERE r.id = :id"),
    @NamedQuery(name = "Reaction.findByCreated", query = "SELECT r FROM Reaction r WHERE r.created = :created"),
    @NamedQuery(name = "Reaction.findByRating", query = "SELECT r FROM Reaction r WHERE r.rating = :rating"),
    @NamedQuery(name = "Reaction.findByAppointmentId", query = "SELECT r FROM Reaction r WHERE r.appointmentId = :appointmentId")})
public class Reaction implements Serializable {

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
    
    @Basic(optional = false)
    @Column(name = "rating", nullable = false)
    private int rating;
    
    @Column(name = "appointment_id")
    private Integer appointmentId;
    
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Users clientId;

    /**
     * 
     */
    public Reaction() {
    }

    /**
     * 
     * @param id 
     */
    public Reaction(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @param id
     * @param created
     * @param rating 
     */
    public Reaction(Integer id, Date created, int rating) {
        this.id = id;
        this.created = created;
        this.rating = rating;
    }

    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
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
    public int getRating() {
        return rating;
    }

    /**
     * 
     * @param rating 
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return 
     */
    public Integer getAppointmentId() {
        return appointmentId;
    }

    /**
     * 
     * @param appointmentId 
     */
    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * 
     * @return 
     */
    public Users getClientId() {
        return clientId;
    }

    /**
     * 
     * @param clientId 
     */
    public void setClientId(Users clientId) {
        this.clientId = clientId;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reaction)) {
            return false;
        }
        Reaction other = (Reaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Reaction[ id=" + id + " ]";
    }
    
}
