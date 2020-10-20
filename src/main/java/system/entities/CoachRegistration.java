/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "coaches_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoachRegistration.findAll", query = "SELECT c FROM CoachRegistration c"),
    @NamedQuery(name = "CoachRegistration.findById", query = "SELECT c FROM CoachRegistration c WHERE c.id = :id"),
    @NamedQuery(name = "CoachRegistration.findByRegdate", query = "SELECT c FROM CoachRegistration c WHERE c.regdate = :regdate")})
public class CoachRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regdate")
    @Temporal(TemporalType.DATE)
    private Date regdate;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Coach cid;
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Team tid;

    public CoachRegistration() {
    }

    public CoachRegistration(int id) {
        this.id = id;
    }

    public CoachRegistration(int id, Date regdate) {
        this.id = id;
        this.regdate = regdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Coach getCid() {
        return cid;
    }

    public void setCid(Coach cid) {
        this.cid = cid;
    }

    public Team getTid() {
        return tid;
    }

    public void setTid(Team tid) {
        this.tid = tid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoachRegistration other = (CoachRegistration) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "system.entities.CoachesRegistration[ id=" + id + " ]";
    }
    
}
