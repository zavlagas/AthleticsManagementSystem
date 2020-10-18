/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "gamings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gaming.findAll", query = "SELECT g FROM Gaming g"),
    @NamedQuery(name = "Gaming.findByGid", query = "SELECT g FROM Gaming g WHERE g.gid = :gid"),
    @NamedQuery(name = "Gaming.findByGresult", query = "SELECT g FROM Gaming g WHERE g.gresult = :gresult"),
    @NamedQuery(name = "Gaming.findByGdate", query = "SELECT g FROM Gaming g WHERE g.gdate = :gdate")})
public class Gaming implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private int gid;
    @Size(max = 10)
    @Column(name = "gresult")
    private String gresult;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gdate")
    @Temporal(TemporalType.DATE)
    private Date gdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gid")
    private List<ParticipationGaming> participationGamingList;

    public Gaming() {
    }

    public Gaming(int gid) {
        this.gid = gid;
    }

    public Gaming(int gid, Date gdate) {
        this.gid = gid;
        this.gdate = gdate;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGresult() {
        return gresult;
    }

    public void setGresult(String gresult) {
        this.gresult = gresult;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    @XmlTransient
    public List<ParticipationGaming> getParticipationGamingList() {
        return participationGamingList;
    }

    public void setParticipationGamingList(List<ParticipationGaming> participationGamingList) {
        this.participationGamingList = participationGamingList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.gid;
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
        final Gaming other = (Gaming) obj;
        if (this.gid != other.gid) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "system.entities.Gamings[ gid=" + gid + " ]";
    }
    
}
