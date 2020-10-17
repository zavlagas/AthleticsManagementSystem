/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "participation_gaming")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipationGaming.findAll", query = "SELECT p FROM ParticipationGaming p"),
    @NamedQuery(name = "ParticipationGaming.findById", query = "SELECT p FROM ParticipationGaming p WHERE p.id = :id")})
public class ParticipationGaming implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "arid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AthleteRegistration arid;
    @JoinColumn(name = "gsid", referencedColumnName = "gsid")
    @ManyToOne(optional = false)
    private GamingStats gsid;
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    @ManyToOne(optional = false)
    private Gaming gid;
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    @ManyToOne(optional = false)
    private Stadium sid;

    public ParticipationGaming() {
    }

    public ParticipationGaming(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AthleteRegistration getArid() {
        return arid;
    }

    public void setArid(AthleteRegistration arid) {
        this.arid = arid;
    }

    public GamingStats getGsid() {
        return gsid;
    }

    public void setGsid(GamingStats gsid) {
        this.gsid = gsid;
    }

    public Gaming getGid() {
        return gid;
    }

    public void setGid(Gaming gid) {
        this.gid = gid;
    }

    public Stadium getSid() {
        return sid;
    }

    public void setSid(Stadium sid) {
        this.sid = sid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipationGaming)) {
            return false;
        }
        ParticipationGaming other = (ParticipationGaming) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "system.entities.ParticipationGaming[ id=" + id + " ]";
    }
    
}