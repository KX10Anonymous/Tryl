/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author J-ANONIMO
 */
@Entity
@Table(name = "users", catalog = "tryldb", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"phone"}),
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
   
    @Basic(optional = false)
    @Column(name = "firstname", nullable = false, length = 25)
    private String firstname;
   
    @Basic(optional = false)
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;
   
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
   
    @Basic(optional = false)
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    
    @Basic(optional = false)
    @Column(name = "passwordHash", nullable = false, length = 225)
    private String passwordHash;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Appointments> appointmentsCollection;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private Collection<Appointments> appointmentsC;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Reaction> reactionCollection;

    /**
     * 
     */
    public Users() {
    }

    /**
     * 
     * @param id 
     */
    public Users(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @param id
     * @param firstname
     * @param surname
     * @param email
     * @param phone
     * @param passwordHash 
     */
    public Users(Integer id, String firstname, String surname, String email, String phone, String passwordHash) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
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
    public String getFirstName() {
        return firstname;
    }

    /**
     * 
     * @param firstname 
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * 
     * @return 
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname 
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return 
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * 
     * @param passwordHash 
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * 
     * @return 
     */
    @XmlTransient
    public Collection<Appointments> getAppointmentsCollection() {
        return appointmentsCollection;
    }

    /**
     * 
     * @param appointmentsCollection 
     */
    public void setAppointmentsCollection(Collection<Appointments> appointmentsCollection) {
        this.appointmentsCollection = appointmentsCollection;
    }

    /**
     * 
     * @return 
     */
    @XmlTransient
    public Collection<Appointments> getAppointmentsC() {
        return appointmentsC;
    }

    /**
     * 
     * @param appointmentsC 
     */
    public void setAppointmentsC(Collection<Appointments> appointmentsC) {
        this.appointmentsC = appointmentsC;
    }

    /**
     * 
     * @return 
     */
    @XmlTransient
    public Collection<Reaction> getReactionCollection() {
        return reactionCollection;
    }

    /**
     * 
     * @param reactionCollection 
     */
    public void setReactionCollection(Collection<Reaction> reactionCollection) {
        this.reactionCollection = reactionCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "main.entities.Users[ id=" + id + " ]";
    }
    
}
