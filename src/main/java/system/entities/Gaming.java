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
    private Integer gid;
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

    public Gaming(Integer gid) {
        this.gid = gid;
    }

    public Gaming(Integer gid, Date gdate) {
        this.gid = gid;
        this.gdate = gdate;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
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
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gaming)) {
            return false;
        }
        Gaming other = (Gaming) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.Gamings[ gid=" + gid + " ]";
    }
    
}
