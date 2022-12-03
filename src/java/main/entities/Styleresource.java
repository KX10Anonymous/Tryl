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
@Table(name = "styleresource", catalog = "tryldb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Styleresource.findAll", query = "SELECT s FROM Styleresource s"),
    @NamedQuery(name = "Styleresource.findById", query = "SELECT s FROM Styleresource s WHERE s.id = :id"),
    @NamedQuery(name = "Styleresource.findByAppointmentId", query = "SELECT s FROM Styleresource s WHERE s.appointmentId = :appointmentId"),
    @NamedQuery(name = "Styleresource.findByUrl", query = "SELECT s FROM Styleresource s WHERE s.url = :url"),
    @NamedQuery(name = "Styleresource.findByCreated", query = "SELECT s FROM Styleresource s WHERE s.created = :created")})
public class Styleresource implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
   
    @Basic(optional = false)
    @Column(name = "appointment_id", nullable = false, length = 45)
    private String appointmentId;
    
    @Basic(optional = false)
    @Column(name = "url", nullable = false, length = 260)
    private String url;
    
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @JoinColumn(name = "style_id", referencedColumnName = "style_id")
    @ManyToOne
    private Styles styleId;

    /**
     * 
     */
    public Styleresource() {
    }

    /**
     * 
     * @param id 
     */
    public Styleresource(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @param id
     * @param appointmentId
     * @param url
     * @param created 
     */
    public Styleresource(Integer id, String appointmentId, String url, Date created) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.url = url;
        this.created = created;
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
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * 
     * @param appointmentId 
     */
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * 
     * @return 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url 
     */
    public void setUrl(String url) {
        this.url = url;
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
    public Styles getStyleId() {
        return styleId;
    }

    /**
     * 
     * @param styleId 
     */
    public void setStyleId(Styles styleId) {
        this.styleId = styleId;
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

    /**
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Styleresource)) {
            return false;
        }
        Styleresource other = (Styleresource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Styleresource[ id=" + id + " ]";
    }
    
}
