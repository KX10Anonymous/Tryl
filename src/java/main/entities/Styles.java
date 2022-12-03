/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author J-ANONIMO
 */
@Entity
@Table(name = "styles", catalog = "tryldb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"style_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Styles.findAll", query = "SELECT s FROM Styles s"),
    @NamedQuery(name = "Styles.findByStyleId", query = "SELECT s FROM Styles s WHERE s.styleId = :styleId"),
    @NamedQuery(name = "Styles.findByStyleName", query = "SELECT s FROM Styles s WHERE s.styleName = :styleName"),
    @NamedQuery(name = "Styles.findByAveragePrice", query = "SELECT s FROM Styles s WHERE s.averagePrice = :averagePrice"),
    @NamedQuery(name = "Styles.findByDescription", query = "SELECT s FROM Styles s WHERE s.description = :description"),
    @NamedQuery(name = "Styles.findByCreated", query = "SELECT s FROM Styles s WHERE s.created = :created")})
public class Styles implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "style_id", nullable = false)
    private Integer styleId;
    
    @Basic(optional = false)
    @Column(name = "style_name", nullable = false, length = 50)
    private String styleName;
    
    @Basic(optional = false)
    @Column(name = "average_price", nullable = false)
    private double averagePrice;
    
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 225)
    private String description;
    
    @Basic(optional = false)
    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @OneToMany(mappedBy = "styleId")
    private Collection<Styleresource> styleresourceCollection;

    public Styles() {
    }

    public Styles(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * 
     * @param styleId
     * @param styleName
     * @param averagePrice
     * @param description
     * @param created 
     */
    public Styles(Integer styleId, String styleName, double averagePrice, String description, Date created) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.averagePrice = averagePrice;
        this.description = description;
        this.created = created;
    }

    /**
     * 
     * @return 
     */
    public Integer getStyleId() {
        return styleId;
    }

    /**
     * 
     * @param styleId 
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * 
     * @return 
     */
    public String getStyleName() {
        return styleName;
    }

    /**
     * 
     * @param styleName 
     */
    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    /**
     * 
     * @return 
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * 
     * @param averagePrice 
     */
    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
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
    @XmlTransient
    public Collection<Styleresource> getStyleresourceCollection() {
        return styleresourceCollection;
    }

    /**
     * 
     * @param styleresourceCollection 
     */
    public void setStyleresourceCollection(Collection<Styleresource> styleresourceCollection) {
        this.styleresourceCollection = styleresourceCollection;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (styleId != null ? styleId.hashCode() : 0);
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
        if (!(object instanceof Styles)) {
            return false;
        }
        Styles other = (Styles) object;
        if ((this.styleId == null && other.styleId != null) || (this.styleId != null && !this.styleId.equals(other.styleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.entities.Styles[ styleId=" + styleId + " ]";
    }
    
}
